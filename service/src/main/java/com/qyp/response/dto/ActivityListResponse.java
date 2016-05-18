package com.qyp.response.dto;

import java.io.Serializable;

public class ActivityListResponse implements Serializable {
	private static final long serialVersionUID = 2913580726741430482L;
	private String activityPhotoUrl;
	private String activityTitle;
	private String status;
	private String signUpStatus;
	private String activityId;

	public String getActivityPhotoUrl() {
		return activityPhotoUrl;
	}

	public void setActivityPhotoUrl(String activityPhotoUrl) {
		this.activityPhotoUrl = activityPhotoUrl;
	}

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSignUpStatus() {
		return signUpStatus;
	}

	public void setSignUpStatus(String signUpStatus) {
		this.signUpStatus = signUpStatus;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	@Override
	public String toString() {
		return "ActivityListResponse [activityPhotoUrl=" + activityPhotoUrl
				+ ", activityTitle=" + activityTitle + ", status=" + status
				+ ", signUpStatus=" + signUpStatus + ", activityId="
				+ activityId + "]";
	}

}
