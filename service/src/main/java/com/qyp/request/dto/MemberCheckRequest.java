package com.qyp.request.dto;

import java.io.Serializable;

public class MemberCheckRequest implements Serializable {
    private static final long serialVersionUID = -4552655034226418800L;
    String                    activityId;
    String                    memberId;
    String                    isPass;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getIsPass() {
        return isPass;
    }

    public void setIsPass(String isPass) {
        this.isPass = isPass;
    }

    @Override
    public String toString() {
        return "MemberCheckRequest [activityId=" + activityId + ", memberId=" + memberId + ", isPass=" + isPass + "]";
    }

}
