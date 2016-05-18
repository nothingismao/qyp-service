package com.qyp.response.dto;

import java.io.Serializable;

public class MemberCheckResponse implements Serializable {
	private static final long serialVersionUID = -3394575974547156794L;
	private String memberIdNotPass;

	public String getMemberIdNotPass() {
		return memberIdNotPass;
	}

	public void setMemberIdNotPass(String memberIdNotPass) {
		this.memberIdNotPass = memberIdNotPass;
	}

}
