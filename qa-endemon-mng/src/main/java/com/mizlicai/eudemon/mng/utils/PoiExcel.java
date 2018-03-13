package com.mizlicai.eudemon.mng.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 
 * PoiExcel.java
 *
 * @author lmg 
 * @since 2015年9月10日
 * Copyright © mizhuanglicai
 */
public class PoiExcel {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public String[][] main(MultipartFile thefile) throws FileNotFoundException, IOException {

		String[][] data = getData(thefile, 1);
		printStringArray(data);
		return data;
	}
	/**
	 * 打印excel 数据
	 * @param data
	 */
	public static void printStringArray(String[][] data){
		for(int i =0; i< data.length; i++){
			for(int j=0; j< data[i].length; j++){
				System.out.print(data[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}

	/**
	 * 
	 * 读取Excel的内容
	 * @param file 读取数据的源Excel
	 * @param ignoreRows 读取数据忽略的行数，比如行头不需要读入 忽略的行数为1
	 * @return 读出的Excel中数据的内容
	 * @throws FileNotFoundException
	 * @throws IOException
	 */

	@SuppressWarnings("deprecation")
	public static String[][] getData(MultipartFile file, int ignoreRows)

	throws FileNotFoundException, IOException {
		List<String[]> result = new ArrayList<String[]>();

		int rowSize = 0;

		BufferedInputStream in = new BufferedInputStream(file.getInputStream());

		// 打开HSSFWorkbook
		POIFSFileSystem fs = new POIFSFileSystem(in);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFCell cell = null;

		for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {

			HSSFSheet st = wb.getSheetAt(sheetIndex);

			// 第一行为标题，不取
			for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
				HSSFRow row = st.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				int tempRowSize = row.getLastCellNum() + 1;
				if (tempRowSize > rowSize) {
					rowSize = tempRowSize;
				}
				String[] values = new String[rowSize];
				Arrays.fill(values, "");
				boolean hasValue = false;

				for (short columnIndex = 0; columnIndex <= row.getLastCellNum(); columnIndex++) {

					String value = "";
					cell = row.getCell(columnIndex);//cell是一个单元格
					if (cell != null) {
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;

						case HSSFCell.CELL_TYPE_NUMERIC:
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								Date date = cell.getDateCellValue();
								if (date != null) {
									value = new SimpleDateFormat("yyyy-MM-dd")
											.format(date);
								} else {
									value = "";
								}
							} else {
									value = new BigDecimal(cell
										.getNumericCellValue()).toString();
							}
							break;

						case HSSFCell.CELL_TYPE_FORMULA:
							// 导入时如果为公式生成的数据则无值
							cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							if (cell.getNumericCellValue() != 0) {
								value = String.valueOf(new DecimalFormat("0.0000").format(cell.getNumericCellValue()));
							} else {
//								value = cell.getNumericCellValue() + "";
								value="";
							}

							break;

						case HSSFCell.CELL_TYPE_BLANK:
							break;

						case HSSFCell.CELL_TYPE_ERROR:
							value = "";
							break;

						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = (cell.getBooleanCellValue() == true ? "T"
									: "F");
							break;

						default:
							value = "";
						}
					}
					
					if (columnIndex == 0 && value.trim().equals("")) {
						break;
					}
					
					values[columnIndex] = rightTrim(value);
					hasValue = true;
				}

				if (hasValue) {
					result.add(values);
				}
			}
		}

		in.close();

		String[][] returnArray = new String[result.size()][rowSize];

		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = (String[]) result.get(i);
		}

		return returnArray;
	}
	
	/**
	 * 
	 * 去掉字符串右边的空格
	 * @param str 要处理的字符串
	 * @return 处理后的字符串
	 */

	public static String rightTrim(String str) {
		if (str == null) {
			return "";
		}
		int length = str.length();
		for (int i = length - 1; i >= 0; i--) {
			if (str.charAt(i) != 0x20) {
				break;
			}
			length--;
		}
		return str.substring(0, length);

	}
}