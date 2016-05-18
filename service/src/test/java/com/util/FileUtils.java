package com.util;

import java.io.File;

public class FileUtils {

	public static void main(String[] args) {
		String path = "D:\\AliDrive\\5.work_space\\work2\\qyp\\bundle\\target\\qyp.bundle-1.0-SNAPSHOT-bundle";
		File filePath = new File(path);
		String allPath = "java -classpath .;";
		for (File file : filePath.listFiles()) {
			String tempPath = file.getName();
			allPath += tempPath + ";";
		}
		allPath += " com.qyp.StartQYPApplication";
		System.out.println(allPath);
	}

}
