package com.qyp.response.dto;

public class CreateActivityResponse {

	private int activityId;

	public static CreateActivityResponse create(int activityId) {
		CreateActivityResponse response = new CreateActivityResponse();
		response.activityId = activityId;
		return response;
	}

	@Override
	public String toString() {
		return "CreateActivityResponse [activityId=" + activityId + "]";
	}

}
