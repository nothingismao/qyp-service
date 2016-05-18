package com.qyp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qyp.dal.dao.impl.ActivityDaoImpl;

@SpringBootApplication
public class StartQYPApplication implements CommandLineRunner {

	@Autowired
	private ActivityDaoImpl activityDaoImpl;

	public static void main(String[] args) {
		SpringApplication.run(StartQYPApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println("Start server");
		// ActivityWithBLOBs activity = new ActivityWithBLOBs();
		// activity.setActivityTitle("测试中文");
		// activity.setStartTime("2005-05-05");
		// activity.setEndTime("2005-05-05");
		// activity.setDestination("destination");
		// activity.setCreator("creator");
		// activity.setMinPeopleSize(1);
		// activity.setMaxPeopleSize(30);
		// activity.setBudget("budget");
		// activity.setDeposit("deposit");
		// activity.setDutyList("dutyList");
		// activity.setBoardList("boardList");
		// activity.setPaymentUrl("paymentUrl");
		// activity.setActivityDescription("activityDescription");
		// int maxActivityId = activityDaoImpl.getMaxActivityId();
		// activity.setActivityId(maxActivityId + 1);
		// boolean success = activityDaoImpl.insertActivity(activity);
		// ActivityWithBLOBs activityNew = activityDaoImpl
		// .getActivityByActivityId(String.valueOf(maxActivityId + 1));
		// System.out.println(activityNew);

	}
}
