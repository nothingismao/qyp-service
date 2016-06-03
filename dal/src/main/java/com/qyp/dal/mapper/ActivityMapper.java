package com.qyp.dal.mapper;

import com.qyp.dal.pojo.Activity;
import com.qyp.dal.pojo.ActivityExample;
import com.qyp.dal.pojo.ActivityWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ActivityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Wed Jun 01 10:29:29 CST 2016
     */
    int countByExample(ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Wed Jun 01 10:29:29 CST 2016
     */
    int deleteByExample(ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Wed Jun 01 10:29:29 CST 2016
     */
    int deleteByPrimaryKey(Integer activityId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Wed Jun 01 10:29:29 CST 2016
     */
    int insert(ActivityWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Wed Jun 01 10:29:29 CST 2016
     */
    int insertSelective(ActivityWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Wed Jun 01 10:29:29 CST 2016
     */
    List<ActivityWithBLOBs> selectByExampleWithBLOBs(ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Wed Jun 01 10:29:29 CST 2016
     */
    List<Activity> selectByExample(ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Wed Jun 01 10:29:29 CST 2016
     */
    ActivityWithBLOBs selectByPrimaryKey(Integer activityId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Wed Jun 01 10:29:29 CST 2016
     */
    int updateByExampleSelective(@Param("record") ActivityWithBLOBs record, @Param("example") ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Wed Jun 01 10:29:29 CST 2016
     */
    int updateByExampleWithBLOBs(@Param("record") ActivityWithBLOBs record, @Param("example") ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Wed Jun 01 10:29:29 CST 2016
     */
    int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Wed Jun 01 10:29:29 CST 2016
     */
    int updateByPrimaryKeySelective(ActivityWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Wed Jun 01 10:29:29 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(ActivityWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table activity
     *
     * @mbggenerated Wed Jun 01 10:29:29 CST 2016
     */
    int updateByPrimaryKey(Activity record);
}