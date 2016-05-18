package com.qyp.request.dto;

import java.io.Serializable;

public class ActivityEditRequest implements Serializable {
    private static final long serialVersionUID = -3692774644114672982L;
    String                    activityId;
    String                    activityContent;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    @Override
    public String toString() {
        return "ActivityEditRequest [activityId=" + activityId + ", activityContent=" + activityContent + "]";
    }

}
