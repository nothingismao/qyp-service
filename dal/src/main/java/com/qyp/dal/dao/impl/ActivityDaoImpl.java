package com.qyp.dal.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qyp.dal.dao.ActivityDao;
import com.qyp.dal.mapper.ActivityMapper;
import com.qyp.dal.pojo.Activity;
import com.qyp.dal.pojo.ActivityExample;
import com.qyp.dal.pojo.ActivityWithBLOBs;

@Repository
public class ActivityDaoImpl implements ActivityDao {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public List<Activity> getAllActivities() {
        ActivityExample example = new ActivityExample();
        example.createCriteria();
        List<Activity> listResult = activityMapper.selectByExample(example);
        return listResult;
    }

    /**
     * 按照id获取activityContent信息
     */
    public ActivityWithBLOBs getActivityByActivityId(String activityId) {
        return (ActivityWithBLOBs) activityMapper.selectByPrimaryKey(Integer.valueOf(activityId));
    }

    public boolean editActivity(ActivityWithBLOBs activity) {
        ActivityExample example = new ActivityExample();
        example.createCriteria().andActivityIdEqualTo(activity.getActivityId());
        int result = activityMapper.updateByExample(activity, example);
        if (result == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean insertActivity(ActivityWithBLOBs activity) {
        activity.setGmtCreate(new Date());
        activity.setGmtModified(new Date());
        int result = activityMapper.insert(activity);
        if (result == 1) {
            return true;
        }
        return false;
    }

    @Override
    public int getMaxActivityId() {
        ActivityExample example = new ActivityExample();
        example.createCriteria().andActivityIdIsNotNull();
        int count = activityMapper.countByExample(example);
        return count;
    }

}
