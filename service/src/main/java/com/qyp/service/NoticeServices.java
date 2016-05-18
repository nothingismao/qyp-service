package com.qyp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.qyp.dal.dao.ActivityDao;
import com.qyp.dal.dao.MemberActivityDao;
import com.qyp.dal.dao.MemberDao;
import com.qyp.dal.pojo.Member;
import com.qyp.dal.pojo.MemberActivity;
import com.qyp.mail.MailSendService;

@RestController
@RequestMapping(value = "/notice")
public class NoticeServices {
	private Logger logger = LoggerFactory.getLogger(NoticeServices.class);
	@Autowired
	private ActivityDao activityDao;

	@Autowired
	private MemberActivityDao memberActivityDao;

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private MailSendService mailSendService;

	@RequestMapping(value = "noticeSingupSuccess", method = RequestMethod.GET)
	public void noticeSignUpSuccess(@RequestParam String activityId) {
		logger.debug("noticeSignUpSuccess:" + activityId.toString());
		List<String> toAddress = getEmailLsit(activityId, "pass");
		String activityTitle = activityDao.getActivityByActivityId(activityId)
				.getActivityTitle();
		mailSendService.sendSuccessEmail(toAddress.toArray(new String[0]),
				activityTitle);
	}

	@RequestMapping(value = "noticeSingupFail", method = RequestMethod.GET)
	public void noticeSignUpFail(@RequestParam String activityId) {
		logger.debug("noticeSignUpFail:" + activityId.toString());
		List<String> toAddress = getEmailLsit(activityId, "notPass");
		String activityTitle = activityDao.getActivityByActivityId(activityId)
				.getActivityTitle();
		mailSendService.sendFailEmail(toAddress.toArray(new String[0]),
				activityTitle);
	}

	private List<String> getEmailLsit(String activityId, String passStatus) {
		List<String> toAddress = Lists.newArrayList();
		List<MemberActivity> memberActivitys = memberActivityDao
				.getMemberListByActivityId(activityId);
		for (MemberActivity memberActivity : memberActivitys) {
			String isPass = memberActivity.getSingUpStatus();
			if (passStatus.equalsIgnoreCase(isPass)) {
				String memberid = memberActivity.getMemberId();
				Member member = memberDao.getMemberById(memberid);
				if (member != null && !Strings.isNullOrEmpty(member.getEmail())) {
					toAddress.add(member.getEmail());
				}
			}
		}
		return toAddress;
	}

}
