package com.qyp.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSendServiceImpl implements MailSendService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendSuccessEmail(String[] toAddress, String activityTitle) {
		MimeMessage mail = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mail, true);
			helper.setTo(toAddress);
			helper.setReplyTo("nothingismao@gmail.com");
			helper.setFrom("nothingismao@gmail.com");
			helper.setSubject("【穷游派】报名成功");
			helper.setText("【"+activityTitle + "】恭喜你成功报名");
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
		}
		javaMailSender.send(mail);
	}

	public void sendFailEmail(String[] toAddress, String activityTitle) {
		MimeMessage mail = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mail, true);
			helper.setTo(toAddress);
			helper.setReplyTo("nothingismao@gmail.com");
			helper.setFrom("nothingismao@gmail.com");
			helper.setSubject("报名失败");
			helper.setText(activityTitle + "很抱歉报名失败");
		} catch (MessagingException e) {
			e.printStackTrace();
		} finally {
		}
		javaMailSender.send(mail);
	}

}
