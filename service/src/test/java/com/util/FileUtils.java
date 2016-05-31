package com.util;

import java.io.File;

public class FileUtils {

	public static void main(String[] args) {
		String path = "D:\\Workspaces\\eclipse\\qyp-service\\bundle\\target\\qyp.bundle-1.0-SNAPSHOT-bundle";
		File filePath = new File(path);
		String allPath = "java -cp .:";
		for (File file : filePath.listFiles()) {
			String tempPath = file.getName();
			allPath += "lib/" + tempPath + ":";
		}
		allPath = allPath.substring(0, allPath.length() - 1)
				+ " com.qyp.StartQYPApplication";
		System.out.println(allPath);
	}

}
