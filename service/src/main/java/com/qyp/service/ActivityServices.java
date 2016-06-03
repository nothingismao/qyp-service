package com.qyp.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qyp.dal.dao.ActivityDao;
import com.qyp.dal.dao.MemberActivityDao;
import com.qyp.dal.dao.MemberDao;
import com.qyp.dal.pojo.Activity;
import com.qyp.dal.pojo.ActivityWithBLOBs;
import com.qyp.dal.pojo.Member;
import com.qyp.dal.pojo.MemberActivity;
import com.qyp.request.dto.ActivityEditRequest;
import com.qyp.request.dto.ActivitySignUpRequest;
import com.qyp.request.dto.CreateActivityRequest;
import com.qyp.response.dto.ActivityListResponse;
import com.qyp.response.dto.ActivityShowResponse;
import com.qyp.response.dto.CreateActivityResponse;
import com.qyp.response.dto.MemberListResponse;
import com.qyp.response.dto.ResponseDto;
import com.qyp.service.handler.ActivityHandler;

@RestController
@RequestMapping("/activity")
public class ActivityServices {
	private Logger logger = LoggerFactory.getLogger(ActivityServices.class);
	@Autowired
	private ActivityDao activityDao;

	@Autowired
	private MemberActivityDao memberActivityDao;

	@Autowired
	private MemberDao memberDao;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto create(@RequestBody CreateActivityRequest request) {
		logger.debug(request.toString());
		ActivityWithBLOBs activity = new ActivityWithBLOBs();
		BeanUtils.copyProperties(request, activity);
		int maxActivityId = activityDao.getMaxActivityId();
		int currentActivityId = maxActivityId + 1;
		activity.setActivityId(currentActivityId);
		boolean isSuccess = true;
		String errorMessage = null;
		try {
			isSuccess = activityDao.insertActivity(activity);
		} catch (Exception e) {
			isSuccess = false;
			errorMessage = e.getMessage();
		}
		return ResponseDto.create(isSuccess, errorMessage,
				CreateActivityResponse.create(currentActivityId));
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public ResponseDto signUp(@RequestBody ActivitySignUpRequest request) {
		logger.debug(request.toString());
		boolean exist = memberDao.isExist(request.getMemberId());
		Member member = new Member();
		BeanUtils.copyProperties(request, member);
		if (exist == false) {
			memberDao.insertMember(member);
		} else {
			memberDao.updateMember(member);
		}
		exist = memberActivityDao.isExist(request.getMemberId(),Integer.valueOf(request.getActivityId()));
		if(exist){
			return ResponseDto.create(false, "报名失败，已存在报名记录");
		}
		MemberActivity memberActivity = new MemberActivity();
		memberActivity.setActivityId(Integer.valueOf(request.getActivityId()));
		memberActivity.setMemberId(request.getMemberId());
		memberActivity.setBoard(request.getBoard());
		memberActivity.setDuty(request.getDuty());
		memberActivity.setSingUpStatus("nonCheck");//nonCheck未审核
		memberActivityDao.insertMemberActivity(memberActivity);
		return ResponseDto.create(true, null);
	}

	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	public ResponseDto summary(@RequestParam String activityId) {
		logger.debug(activityId);
		// ActivitySummaryResponse response = new ActivitySummaryResponse();
		boolean success = true;
		String errorMessage = null;
		Activity activity = null;
		try {
			activity = activityDao.getActivityByActivityId(activityId);
		} catch (Exception e) {
			success = false;
			errorMessage = e.getMessage();
		}
		return ResponseDto.create(success, errorMessage, activity);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ResponseDto edit(@RequestBody ActivityEditRequest request) {
		ActivityWithBLOBs activity = new ActivityWithBLOBs();
		activity.setActivityId(Integer.valueOf(request.getActivityId()));
		activity.setActivityContent(request.getActivityContent());
		boolean success = true;
		String errorMessage = null;
		try {
			success = activityDao.editActivity(activity);
		} catch (Exception e) {
			success = false;
			errorMessage = e.getMessage();
		}
		return ResponseDto.create(success, errorMessage);
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ResponseDto show(@RequestParam(required = false) String activityId) {
		ActivityShowResponse response = new ActivityShowResponse();
		boolean success = true;
		String errorMessage = null;
		try {
			ActivityWithBLOBs activity = activityDao
					.getActivityByActivityId(activityId);
			BeanUtils.copyProperties(activity, response);
		} catch (Exception e) {
			success = false;
			errorMessage = e.getMessage();
		}
		return ResponseDto.create(success, errorMessage, response);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseDto list(@RequestParam String memberId) {
		List<ActivityListResponse> resultList = new ArrayList<ActivityListResponse>();
		boolean success = true;
		String errorMessage = null;
		try {
			if (StringUtils.isEmpty(memberId)) {
				List<Activity> activities = activityDao.getAllActivities();
				for (Activity activity : activities) {
					ActivityListResponse response = new ActivityListResponse();
					response.setActivityId(String.valueOf(activity
							.getActivityId()));
					response.setActivityPhotoUrl(activity.getActivityPhotoUrl());
					response.setActivityTitle(activity.getActivityTitle());
					response.setStatus(activity.getStatus());
					resultList.add(response);
				}
			} else {
				List<MemberActivity> memberActivitys = memberActivityDao
						.getMemberListByMemberId(memberId);
				for (MemberActivity memberActivity : memberActivitys) {
					int activityId = memberActivity.getActivityId();
					ActivityWithBLOBs activity = activityDao
							.getActivityByActivityId(String.valueOf(activityId));
					ActivityListResponse response = new ActivityListResponse();
					response.setActivityId(String.valueOf(activity
							.getActivityId()));
					response.setActivityPhotoUrl(activity.getActivityPhotoUrl());
					response.setActivityTitle(activity.getActivityTitle());
					response.setStatus(activity.getStatus());
					response.setSignUpStatus(memberActivity.getSingUpStatus()); // 璁剧疆褰撳墠鐢ㄦ埛鐨勬椿鍔ㄧ姸鎬�
					resultList.add(response);
				}
			}
		} catch (Exception e) {
			success = false;
			errorMessage = e.getMessage();
		}
		return ResponseDto.create(success, errorMessage, resultList);
	}

	@RequestMapping(value = "/activity/download", method = RequestMethod.GET)
	@ResponseBody
	public FileSystemResource getMemberList(String activityId) {
		File file = new File("abc.test");
		if (file.exists() == false) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new FileSystemResource(file);
	}

	@RequestMapping(value = "/downloadMemberList", method = RequestMethod.GET)
	public void getFile(String activityId, HttpServletResponse response)
			throws IOException {

		List<MemberListResponse> resultList = new ArrayList<MemberListResponse>();
		List<MemberActivity> memberActivitys = memberActivityDao
				.getMemberListByActivityId(activityId);
		for (MemberActivity memberActivity : memberActivitys) {
			String memberId = memberActivity.getMemberId();
			Member member = memberDao.getMemberById(memberId);
			MemberListResponse response2 = new MemberListResponse();
			response2.setId(String.valueOf(memberActivity.getId()));
			response2.setIsSingle(member.getIsSingle());
			response2.setMemberId(memberId);
			response2.setNickName(member.getNickName());
			response2.setPhoneNumber(member.getPhoneNumber());
			response2.setSex(member.getSex());
			response2.setSingUpStatus(memberActivity.getSingUpStatus());
			response2.setTalent(member.getTalent());
			response2.setEmail(member.getEmail());
			response2.setDuty(memberActivity.getDuty());
			response2.setBoard(memberActivity.getBoard());
			response2.setPassPort(member.getPassPort());
			response2.setRealName(member.getRealName());
			resultList.add(response2);
		}
		String fileName = ActivityHandler.buildMemberListFile(resultList);
		File file = new File(fileName);
		if (file.exists() == false) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		InputStream is = new FileInputStream(file);
		response.setHeader("content-type", "application/vnd.ms-excel");
		IOUtils.copy(is, response.getOutputStream());
		response.flushBuffer();
	}
}
