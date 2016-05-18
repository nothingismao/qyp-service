package com.qyp.request.dto;

import org.junit.Test;

import qyp.common.utils.GsonUtils;

import com.qyp.request.dto.MemberCheckRequest;

public class MemberCheckRequestTest {

    @Test
    public void testJson() {
        MemberCheckRequest request = new MemberCheckRequest();
        request.setActivityId("aaaa");

        System.out.println(GsonUtils.toJson(request));
        //{"activityId":"aaaa","memberList":[{"memberId":"memberId1","isPass":true},{"memberId":"memberId2","isPass":false}]}
    }
}
