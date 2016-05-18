package com.qyp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qyp.dal.dao.MemberActivityDao;
import com.qyp.dal.dao.MemberDao;
import com.qyp.dal.pojo.Member;
import com.qyp.dal.pojo.MemberActivity;
import com.qyp.request.dto.MemberCheckRequest;
import com.qyp.response.dto.MemberCheckResponse;
import com.qyp.response.dto.MemberListResponse;
import com.qyp.response.dto.ResponseDto;

@RestController
@RequestMapping("/member")
public class MemberServices {
	private Logger logger = LoggerFactory.getLogger(MemberServices.class);
	@Autowired
	private MemberActivityDao memberActivityDao;

	@Autowired
	private MemberDao memberDao;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseDto list(@RequestParam String activityId) {
		logger.debug("list:" + activityId.toString());
		List<MemberListResponse> resultList = new ArrayList<MemberListResponse>();
		List<MemberActivity> memberActivitys = memberActivityDao
				.getMemberListByActivityId(activityId);
		for (MemberActivity memberActivity : memberActivitys) {
			String memberId = memberActivity.getMemberId();
			Member member = memberDao.getMemberById(memberId);
			MemberListResponse response = new MemberListResponse();
			response.setIsSingle(member.getIsSingle());
			response.setMemberId(memberId);
			response.setNickName(member.getNickName());
			response.setPhoneNumber(member.getPhoneNumber());
			response.setSex(member.getSex());
			response.setSingUpStatus(memberActivity.getSingUpStatus());
			resultList.add(response);
		}
		return ResponseDto.create(true, null, resultList);
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public ResponseDto check(@RequestBody MemberCheckRequest memberCheckRequest) {
		logger.debug("check:" + memberCheckRequest.toString());
		MemberCheckResponse response = new MemberCheckResponse();
		boolean success = true;
		String errorMessage = null;
		try {
			MemberActivity memberActivity = new MemberActivity();
			memberActivity.setActivityId(Integer.valueOf(memberCheckRequest
					.getActivityId()));
			memberActivity.setMemberId(memberCheckRequest.getMemberId());
			memberActivity.setSingUpStatus(memberCheckRequest.getIsPass());
			boolean result = memberActivityDao
					.updateMemberStatus(memberActivity);
			if (result == false) {
				response.setMemberIdNotPass(memberCheckRequest.getMemberId());
			}
		} catch (Exception e) {
			success = false;
			errorMessage = e.getMessage();
		}
		return ResponseDto.create(success, errorMessage);
	}

}
