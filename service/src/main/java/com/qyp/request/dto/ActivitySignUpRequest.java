package com.qyp.request.dto;

import java.io.Serializable;

public class ActivitySignUpRequest implements Serializable {
    private static final long serialVersionUID = 4964792258133514624L;
    String                    memberId;
    String                    nickName;
    int                       age;
    String                    sex;
    String                    board;
    String                    talent;
    String                    duty;
    String                    remarks;
    String                    activityId;
    boolean                   isSettingDefault;
    String                    isSingle;
    String                    phoneNumber;
    String                    email;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getTalent() {
        return talent;
    }

    public void setTalent(String talent) {
        this.talent = talent;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public boolean isSettingDefault() {
        return isSettingDefault;
    }

    public void setSettingDefault(boolean isSettingDefault) {
        this.isSettingDefault = isSettingDefault;
    }

    public String getIsSingle() {
        return isSingle;
    }

    public void setIsSingle(String isSingle) {
        this.isSingle = isSingle;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ActivitySingUpRequest [memberId=" + memberId + ", nickName=" + nickName + ", age=" + age + ", sex="
                + sex + ", board=" + board + ", talent=" + talent + ", duty=" + duty + ", remarks=" + remarks
                + ", activityId=" + activityId + ", isSettingDefault=" + isSettingDefault + ", isSingle=" + isSingle
                + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
    }

}
