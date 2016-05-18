package com.qyp.dal.dao;

import com.qyp.dal.pojo.Member;

public interface MemberDao {

    public Member getMemberById(String memberId);

    public boolean insertMember(Member member);

    public boolean updateMember(Member member);

    public boolean isExist(String memberId);
}
