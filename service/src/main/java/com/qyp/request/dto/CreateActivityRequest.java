package com.qyp.request.dto;

import java.io.Serializable;

public class CreateActivityRequest implements Serializable {
	private static final long serialVersionUID = 1111225583733407677L;
	String activityTitle;
	String startTime;
	String endTime;
	String destination;
	String creator;
	int minPeopleSize;
	int maxPeopleSize;
	String budget;
	String deposit;
	String dutyList; // 使用|符号分割 例如: 财务|领队|交通
	String boardList; // 使用|符号分割地点，-分割时间 例如: 7:20-武林广场|7：50-淘宝城
	String paymentUrl;
	String creatorPhonenumber;
	String activityDescription;

	public String getActivityTitle() {
		return activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
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

	public String getDutyList() {
		return dutyList;
	}

	public void setDutyList(String dutyList) {
		this.dutyList = dutyList;
	}

	public String getBoardList() {
		return boardList;
	}

	public void setBoardList(String boardList) {
		this.boardList = boardList;
	}

	public String getPaymentUrl() {
		return paymentUrl;
	}

	public void setPaymentUrl(String paymentUrl) {
		this.paymentUrl = paymentUrl;
	}

	public String getCreatorPhonenumber() {
		return creatorPhonenumber;
	}

	public void setCreatorPhonenumber(String creatorPhonenumber) {
		this.creatorPhonenumber = creatorPhonenumber;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	@Override
	public String toString() {
		return "CreateActivityRequest [activityTitle=" + activityTitle
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", destination=" + destination + ", creator=" + creator
				+ ", minPeopleSize=" + minPeopleSize + ", maxPeopleSize="
				+ maxPeopleSize + ", budget=" + budget + ", deposit=" + deposit
				+ ", dutyList=" + dutyList + ", boardList=" + boardList
				+ ", paymentUrl=" + paymentUrl + ", creatorPhonenumber="
				+ creatorPhonenumber + ", activityDescription="
				+ activityDescription + "]";
	}

}
