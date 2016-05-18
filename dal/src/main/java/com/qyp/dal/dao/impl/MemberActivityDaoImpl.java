package com.qyp.dal.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qyp.dal.dao.MemberActivityDao;
import com.qyp.dal.mapper.MemberActivityMapper;
import com.qyp.dal.pojo.MemberActivity;
import com.qyp.dal.pojo.MemberActivityExample;

@Repository
public class MemberActivityDaoImpl implements MemberActivityDao {

    @Autowired
    private MemberActivityMapper memberActivityMapper;

    public boolean insertMemberActivity(MemberActivity memberActivity) {
        memberActivity.setGmtCreate(new Date());
        memberActivity.setGmtModified(new Date());
        memberActivity.setIsDeleted("n");
        int result = memberActivityMapper.insert(memberActivity);
        if (result == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<MemberActivity> getMemberListByActivityId(String activityId) {
        MemberActivityExample example = new MemberActivityExample();
        example.createCriteria().andActivityIdEqualTo(Integer.valueOf(activityId));
        List<MemberActivity> memberActivitys = memberActivityMapper.selectByExample(example);
        return memberActivitys;
    }

    @Override
    public List<MemberActivity> getMemberListByMemberId(String memberId) {
        MemberActivityExample example = new MemberActivityExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        List<MemberActivity> memberActivitys = memberActivityMapper.selectByExample(example);
        return memberActivitys;
    }

    /**
     * 按照activityId 和memberId 跟新审批状态
     */
    @Override
    public boolean updateMemberStatus(MemberActivity memberActivity) {

        MemberActivityExample example = new MemberActivityExample();
        example.createCriteria().andActivityIdEqualTo(Integer.valueOf(memberActivity.getActivityId()))
                .andMemberIdEqualTo(memberActivity.getMemberId());
        int result = memberActivityMapper.updateByExample(memberActivity, example);
        if (result == 1) {
            return true;
        }

        return false;
    }
}
