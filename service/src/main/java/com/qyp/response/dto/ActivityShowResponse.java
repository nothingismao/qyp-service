package com.qyp.response.dto;

import java.io.Serializable;

public class ActivityShowResponse implements Serializable {
	private static final long serialVersionUID = 5886426904739466105L;
	String activityContent;
	String activityPhotoUtl;

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public String getActivityPhotoUtl() {
		return activityPhotoUtl;
	}

	public void setActivityPhotoUtl(String activityPhotoUtl) {
		this.activityPhotoUtl = activityPhotoUtl;
	}

}
