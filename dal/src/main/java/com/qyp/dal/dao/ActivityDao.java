package com.qyp.dal.dao;

import java.util.List;

import com.qyp.dal.pojo.Activity;
import com.qyp.dal.pojo.ActivityWithBLOBs;

public interface ActivityDao {

    public List<Activity> getAllActivities();

    public boolean insertActivity(ActivityWithBLOBs activity);

    public int getMaxActivityId();

    public ActivityWithBLOBs getActivityByActivityId(String activityId);

    public boolean editActivity(ActivityWithBLOBs activity);

}
