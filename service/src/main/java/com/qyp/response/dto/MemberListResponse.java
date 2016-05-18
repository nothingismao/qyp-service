package com.qyp.response.dto;

import java.io.Serializable;

public class MemberListResponse implements Serializable {
	private static final long serialVersionUID = -1119371073833209196L;
	private String memberId;
	private String nickName;
	private String isSingle;
	private String sex;
	private String singUpStatus;
	private String phoneNumber;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getIsSingle() {
		return isSingle;
	}

	public void setIsSingle(String isSingle) {
		this.isSingle = isSingle;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSingUpStatus() {
		return singUpStatus;
	}

	public void setSingUpStatus(String singUpStatus) {
		this.singUpStatus = singUpStatus;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
