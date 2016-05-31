package com.qyp.service.handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import com.qyp.response.dto.MemberListResponse;

public class ActivityHandler {

	public static String buildMemberListFile(List<MemberListResponse> members) {
		SXSSFWorkbook workbook = new SXSSFWorkbook(100);
		Sheet sheet = workbook.createSheet();
		Row row = sheet.createRow(0);
		Cell itemValue1 = row.getCell(0, Row.CREATE_NULL_AS_BLANK);
		itemValue1.setCellValue("memberId");
		Cell itemValue2 = row.getCell(1, Row.CREATE_NULL_AS_BLANK);
		itemValue2.setCellValue("nickName");
		Cell itemValue3 = row.getCell(2, Row.CREATE_NULL_AS_BLANK);
		itemValue3.setCellValue("isSingle");
		Cell itemValue4 = row.getCell(3, Row.CREATE_NULL_AS_BLANK);
		itemValue4.setCellValue("sex");
		Cell itemValue5 = row.getCell(4, Row.CREATE_NULL_AS_BLANK);
		itemValue5.setCellValue("singUpStatus");
		Cell itemValue6 = row.getCell(5, Row.CREATE_NULL_AS_BLANK);
		itemValue6.setCellValue("phoneNumber");
		Cell itemValue7 = row.getCell(6, Row.CREATE_NULL_AS_BLANK);
		itemValue7.setCellValue("duty");
		Cell itemValue8 = row.getCell(7, Row.CREATE_NULL_AS_BLANK);
		itemValue8.setCellValue("talent");
		Cell itemValue9 = row.getCell(8, Row.CREATE_NULL_AS_BLANK);
		itemValue9.setCellValue("email");

		for (int i = 0; i < members.size(); i++) {
			MemberListResponse member = members.get(i);
			Row rowValue = sheet.createRow(i + 1);
			Cell memberValue1 = rowValue.getCell(0, Row.CREATE_NULL_AS_BLANK);
			memberValue1.setCellValue(member.getMemberId());
			Cell memberValue2 = rowValue.getCell(1, Row.CREATE_NULL_AS_BLANK);
			memberValue2.setCellValue(member.getNickName());
			Cell memberValue3 = rowValue.getCell(2, Row.CREATE_NULL_AS_BLANK);
			memberValue3.setCellValue(member.getIsSingle());
			Cell memberValue4 = rowValue.getCell(3, Row.CREATE_NULL_AS_BLANK);
			memberValue4.setCellValue(member.getSex());
			Cell memberValue5 = rowValue.getCell(4, Row.CREATE_NULL_AS_BLANK);
			memberValue5.setCellValue(member.getSingUpStatus());
			Cell memberValue6 = rowValue.getCell(5, Row.CREATE_NULL_AS_BLANK);
			memberValue6.setCellValue(member.getPhoneNumber());
			Cell memberValue7 = rowValue.getCell(6, Row.CREATE_NULL_AS_BLANK);
			memberValue7.setCellValue(member.getDuty());
			Cell memberValue8 = rowValue.getCell(7, Row.CREATE_NULL_AS_BLANK);
			memberValue8.setCellValue(member.getTalent());
			Cell memberValue9 = rowValue.getCell(8, Row.CREATE_NULL_AS_BLANK);
			memberValue9.setCellValue(member.getEmail());
		}
		FileOutputStream fout = null;
		String fileName = UUID.randomUUID().toString() + ".xls";
		File file = new File(fileName);
		if(file.exists()==false){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			fout = new FileOutputStream(fileName);
			workbook.write(fout);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (workbook != null) {
			IOUtils.closeQuietly(workbook);
		}
		return fileName;
	}

	public static void main(String[] args) throws Throwable {
		SXSSFWorkbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory,
													// exceeding rows will be
													// flushed to disk
		Sheet sh = wb.createSheet();
		for (int rownum = 0; rownum < 1000; rownum++) {
			Row row = sh.createRow(rownum);
			for (int cellnum = 0; cellnum < 10; cellnum++) {
				Cell cell = row.createCell(cellnum);
				String address = new CellReference(cell).formatAsString();
				cell.setCellValue(address);
			}

		}

		// Rows with rownum < 900 are flushed and not accessible
		for (int rownum = 0; rownum < 900; rownum++) {
			Assert.assertNull(sh.getRow(rownum));
		}

		// ther last 100 rows are still in memory
		for (int rownum = 900; rownum < 1000; rownum++) {
			Assert.assertNotNull(sh.getRow(rownum));
		}

		FileOutputStream out = new FileOutputStream("/temp/sxssf.xlsx");
		wb.write(out);
		out.close();

		// dispose of temporary files backing this workbook on disk
		wb.dispose();
	}
}
