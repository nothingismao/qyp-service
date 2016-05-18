package com.qyp.mail;

public interface MailSendService {
    public void sendSuccessEmail(String[] toAddress, String activityTitle);

    public void sendFailEmail(String[] toAddress, String activityTitle);
}
