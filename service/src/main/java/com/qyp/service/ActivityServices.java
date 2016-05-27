package com.qyp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
import com.qyp.response.dto.ResponseDto;

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
		logger.debug("create:" + request.toString());
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
	public ResponseDto singUp(@RequestBody ActivitySignUpRequest request) {
		logger.debug("signUp:" + request.toString());
		boolean isSuccess = true;
		String errorMessage = null;
		try {
			boolean exist = memberDao.isExist(request.getMemberId());
			Member member = new Member();
			BeanUtils.copyProperties(request, member);
			if (exist == false) {
				memberDao.insertMember(member);
			} else {
				memberDao.updateMember(member);
			}
			MemberActivity memberActivity = new MemberActivity();
			memberActivity.setActivityId(Integer.valueOf(request
					.getActivityId()));
			memberActivity.setDuty(request.getDuty());
			memberActivity.setMemberId(request.getMemberId());
			memberActivity.setSingUpStatus("noPass");
			memberActivity.setDuty(request.getDuty());
			memberActivity.setNickName(request.getNickName());
			if (memberActivityDao.updateMemberStatus(memberActivity) == false) {
				memberActivityDao.insertMemberActivity(memberActivity);
			}
		} catch (Exception e) {
			isSuccess = false;
			errorMessage = e.getMessage();
		}
		return ResponseDto.create(isSuccess, errorMessage);
	}

	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	public ResponseDto summary(@RequestParam String activityId) {
		logger.debug("summary:" + activityId.toString());
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

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ResponseDto edit(@RequestBody ActivityEditRequest request) {
		logger.debug("edit:" + request.toString());
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
	public ResponseDto show(String activityId) {
		logger.debug("show:" + activityId.toString());
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
		logger.debug("list:" + memberId.toString());
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

}
