package com.qyp.dal.dao;

import java.util.List;

import com.qyp.dal.pojo.MemberActivity;

public interface MemberActivityDao {

    public boolean updateMemberStatus(MemberActivity memberActivity);

    public List<MemberActivity> getMemberListByActivityId(String activityId);

    public List<MemberActivity> getMemberListByMemberId(String memberId);

    public boolean insertMemberActivity(MemberActivity memberActivity);

	public boolean isExist(String memberId, Integer valueOf);
}
