package com.glmht.excelDemo.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImportExcel {
	// abc.xls
	public static boolean isXls(String fileName) {
		// (?i)忽略大小写
		if (fileName.matches("^.+\\.(?i)(xls)$")) {
			return true;
		} else if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
			return false;
		} else {
			throw new RuntimeException("格式不对");
		}
	}
	
	
	public static void main(String[] args) {
		String ss = "1.2.2";
		System.out.println(ss.substring(ss.lastIndexOf(".")));
	}

	public static List<Map<String, Object>> readExcel(String fileName, InputStream inputStream) throws Exception {

		boolean ret = isXls(fileName);
		Workbook workbook = null;
		// 根据后缀创建不同的对象
		if (ret) {
			workbook = new HSSFWorkbook(inputStream);
		} else {
			workbook = new XSSFWorkbook(inputStream);
		}
		//返回工作薄（Workbook）中工作表（Sheet）对象
		Sheet sheet = workbook.getSheetAt(0);
		// 获取Sheet表标题行
		Row titleRow = sheet.getRow(0);

		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = titleRow.getLastCellNum();

		List<Map<String, Object>> list = new ArrayList<>();

		for (int i = 1; i <= lastRowNum; i++) {
			Map<String, Object> map = new HashMap<>();
			Row row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				// 得到列名
				String key = titleRow.getCell(j).getStringCellValue();
				Cell cell = row.getCell(j);
				String cellValue = "";
				if(cell != null) {
					cell.setCellType(CellType.STRING);
					cellValue = cell.getStringCellValue();
				}
				
				if(cellValue == null) {
					cellValue = "";
				}

				map.put(key.trim(), cellValue.trim());
			}
			list.add(map);
		}
		workbook.close();
		return list;

	}
}