package com.qyp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qyp.dal.dao.impl.ActivityDaoImpl;

@SpringBootApplication
public class SampleMybatisApplication  {

    @Autowired
    private ActivityDaoImpl activityDaoImpl;

    public static void main(String[] args) {
        //        new SpringApplicationBuilder().sources(SampleMybatisApplication.class).profiles("app").run(args);
        SpringApplication.run(SampleMybatisApplication.class, args);
    }

}
