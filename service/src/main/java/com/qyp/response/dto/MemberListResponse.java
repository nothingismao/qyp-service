package com.qyp.response.dto;

import java.io.Serializable;

public class MemberListResponse implements Serializable {
	private static final long serialVersionUID = -1119371073833209196L;
	private String id;
	private String memberId;
	private String nickName;
	private String isSingle;
	private String sex;
	private String singUpStatus;
	private String phoneNumber;
	private String duty;
	private String talent;
	private String email;
	private String board;
	private String passPort;
	private String realName;

	public String getPassPort() {
		return passPort;
	}

	public void setPassPort(String passPort) {
		this.passPort = passPort;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

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

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getTalent() {
		return talent;
	}

	public void setTalent(String talent) {
		this.talent = talent;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberListResponse [memberId=" + memberId + ", nickName="
				+ nickName + ", isSingle=" + isSingle + ", sex=" + sex
				+ ", singUpStatus=" + singUpStatus + ", phoneNumber="
				+ phoneNumber + ", duty=" + duty + ", talent=" + talent
				+ ", email=" + email + "]";
	}

}
