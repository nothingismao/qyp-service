package com.qyp.dal.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qyp.dal.dao.ActivityDao;
import com.qyp.dal.dao.MemberDao;
import com.qyp.dal.mapper.ActivityMapper;
import com.qyp.dal.mapper.MemberActivityMapper;
import com.qyp.dal.mapper.MemberMapper;
import com.qyp.dal.pojo.Activity;
import com.qyp.dal.pojo.ActivityExample;
import com.qyp.dal.pojo.Member;
import com.qyp.dal.pojo.MemberActivity;
import com.qyp.dal.pojo.MemberActivityExample;
import com.qyp.dal.pojo.MemberExample;

@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private MemberMapper memberMapper;

    public boolean insertMember(Member member) {
        member.setGmtCreate(new Date());
        member.setGmtModified(new Date());
        member.setIsDeleted("n");
        int result = memberMapper.insert(member);
        if (result == 1) {
            return true;
        }
        return false;
    }

    public Member getMemberById(String memberId) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMemberIdEqualTo(memberId);
        List<Member> members = memberMapper.selectByExample(memberExample);
        if (members != null && members.size() > 0) {
            Member member = members.get(0);
            return member;
        }
        return null;
    }

    @Override
    public boolean isExist(String memberId) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMemberIdEqualTo(memberId);
        List<Member> members = memberMapper.selectByExample(memberExample);
        if (members != null && members.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateMember(Member member) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMemberIdEqualTo(member.getMemberId());
        int result = memberMapper.updateByExample(member, memberExample);
        if (result == 1) {
            return true;
        }
        return false;
    }
}
