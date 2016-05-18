package com.qyp.response.dto;

import java.io.Serializable;
import java.util.Date;

public class ActivitySummaryResponse implements Serializable {
	private static final long serialVersionUID = 7144400164730123621L;
	private String activityTitle;
	private String creator;
	private Date startTime;
	private Date endTime;
	private int minPeopleSize;
	private int maxPeopleSize;
	private String budget;
	private String deposit;
	private String activityDescription;
	private String activityPhotoUtl;

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getMinPeopleSize() {
		return minPeopleSize;
	}

	public void setMinPeopleSize(int minPeopleSize) {
		this.minPeopleSize = minPeopleSize;
	}

	public int getMaxPeopleSize() {
		return maxPeopleSize;
	}

	public void setMaxPeopleSize(int maxPeopleSize) {
		this.maxPeopleSize = maxPeopleSize;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public String getActivityPhotoUtl() {
		return activityPhotoUtl;
	}

	public void setActivityPhotoUtl(String activityPhotoUtl) {
		this.activityPhotoUtl = activityPhotoUtl;
	}

	@Override
	public String toString() {
		return "ActivitySummaryResponse [activityTitle=" + activityTitle
				+ ", creator=" + creator + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", minPeopleSize=" + minPeopleSize
				+ ", maxPeopleSize=" + maxPeopleSize + ", budget=" + budget
				+ ", deposit=" + deposit + ", activityDescription="
				+ activityDescription + ", activityPhotoUtl="
				+ activityPhotoUtl + "]";
	}

}
