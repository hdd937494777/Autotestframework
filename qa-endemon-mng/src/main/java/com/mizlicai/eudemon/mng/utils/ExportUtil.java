package com.mizlicai.eudemon.mng.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class ExportUtil {

	private static Workbook wb;

	/**
	 * 网站数据生产excel
	 * 
	 * @param rest
	 * @param os
	 * @return
	 * @throws IOException
	 */

	public static OutputStream exportWebsiteExcel(
			Map<String, Map<String, Map<String, Object>>> rest, OutputStream os)
			throws IOException {

		wb = new HSSFWorkbook();
		Font font = wb.createFont();
		font.setColor(HSSFColor.RED.index);

		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFont(font);

		HSSFSheet sheet = (HSSFSheet) wb.createSheet("report");// 生成一个表格

		sheet.setColumnWidth(1, 4000);

		HSSFRow row = sheet.createRow(0);// 创建行并插入表头
		row.createCell(0).setCellValue("日期");
		row.createCell(1).setCellValue("产品线");
		row.createCell(2).setCellValue("提交用户");
		row.createCell(3).setCellValue("成功交易用户");
		row.createCell(4).setCellValue("新增成功交易用户");
		row.createCell(5).setCellValue("下单总数");
		row.createCell(6).setCellValue("成功交易订单");
		row.createCell(7).setCellValue("交易成功率");
		row.createCell(8).setCellValue("交易金额");
		row.createCell(9).setCellValue("注册用户");
		row.createCell(10).setCellValue("认证用户(绑卡)");
		int i = 0;

		for (Map.Entry<String, Map<String, Map<String, Object>>> entry : rest
				.entrySet()) {
			String realdate = entry.getKey();

			for (Map.Entry<String, Map<String, Object>> secondentry : entry
					.getValue().entrySet()) {
				row = sheet.createRow(i + 1);

				HSSFCell cell0 = row.createCell(0);
				HSSFCell cell1 = row.createCell(1);
				HSSFCell cell2 = row.createCell(2);
				HSSFCell cell3 = row.createCell(3);
				HSSFCell cell4 = row.createCell(4);
				HSSFCell cell5 = row.createCell(5);
				HSSFCell cell6 = row.createCell(6);
				HSSFCell cell7 = row.createCell(7);
				HSSFCell cell8 = row.createCell(8);
				HSSFCell cell9 = row.createCell(9);
				HSSFCell cell10 = row.createCell(10);

				if ("All".equals(secondentry.getKey())) {
					cell0.setCellStyle(cellStyle);
					cell1.setCellStyle(cellStyle);
					cell2.setCellStyle(cellStyle);
					cell3.setCellStyle(cellStyle);
					cell4.setCellStyle(cellStyle);
					cell5.setCellStyle(cellStyle);
					cell6.setCellStyle(cellStyle);
					cell7.setCellStyle(cellStyle);
					cell8.setCellStyle(cellStyle);
					cell9.setCellStyle(cellStyle);
					cell10.setCellStyle(cellStyle);
				}

				cell0.setCellValue(realdate);
				cell1.setCellValue(secondentry.getKey());
				cell2.setCellValue(secondentry.getValue().get("allBuyer")
						.toString());
				cell3.setCellValue(secondentry.getValue().get("DAU").toString());
				cell4.setCellValue(secondentry.getValue().get("newDAU")
						.toString());
				cell5.setCellValue(secondentry.getValue().get("allOrders")
						.toString());
				cell6.setCellValue(secondentry.getValue().get("successOfOrder")
						.toString());
				cell7.setCellValue(secondentry.getValue().get("rate")
						.toString());
				cell8.setCellValue(secondentry.getValue().get("allSales")
						.toString());
				cell9.setCellValue(secondentry.getValue().get("allUsers")
						.toString());
				cell10.setCellValue(secondentry.getValue().get("certifyUsers")
						.toString());
				i++;
			}
		}

		wb.write(os);
		os.flush();
		os.close();
		return os;
	}

	public static OutputStream exportProductExcel(
			Map<String, Map<String, Map<String, Object>>> rest, OutputStream os)
			throws IOException {

		wb = new HSSFWorkbook();
		Font font = wb.createFont();
		font.setColor(HSSFColor.RED.index);

		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFont(font);

		HSSFSheet sheet = (HSSFSheet) wb.createSheet("report");// 生成一个表格

		sheet.setColumnWidth(1, 4000);

		HSSFRow row = sheet.createRow(0);// 创建行并插入表头
		row.createCell(0).setCellValue("日期");
		row.createCell(1).setCellValue("产品");
		row.createCell(2).setCellValue("产品周期");
		row.createCell(3).setCellValue("产品基础收益");
		row.createCell(4).setCellValue("产品加息");
		row.createCell(5).setCellValue("产品上架总份额");
		row.createCell(6).setCellValue("交易次数");
		row.createCell(7).setCellValue("成功交易次数");
		row.createCell(8).setCellValue("交易金额");
		row.createCell(9).setCellValue("成功交易用户数");
		row.createCell(10).setCellValue("交易用户数");
		row.createCell(11).setCellValue("人均ARUP");
		row.createCell(12).setCellValue("交易成功率");
		int i = 0;

		for (Map.Entry<String, Map<String, Map<String, Object>>> entry : rest
				.entrySet()) {
			String realdate = entry.getKey();

			for (Map.Entry<String, Map<String, Object>> secondentry : entry
					.getValue().entrySet()) {

				if (!"0".equals(secondentry.getValue().get("dealTimesAnalyse")
						.toString())) {
					row = sheet.createRow(i + 1);

					HSSFCell cell0 = row.createCell(0);
					HSSFCell cell1 = row.createCell(1);
					HSSFCell cell2 = row.createCell(2);
					HSSFCell cell3 = row.createCell(3);
					HSSFCell cell4 = row.createCell(4);
					HSSFCell cell5 = row.createCell(5);
					HSSFCell cell6 = row.createCell(6);
					HSSFCell cell7 = row.createCell(7);
					HSSFCell cell8 = row.createCell(8);
					HSSFCell cell9 = row.createCell(9);
					HSSFCell cell10 = row.createCell(10);
					HSSFCell cell11 = row.createCell(11);
					HSSFCell cell12 = row.createCell(12);

					cell0.setCellValue(realdate);
					cell1.setCellValue(secondentry.getKey());
					cell2.setCellValue(secondentry.getValue()
							.get("cycleValue").toString());
					cell3.setCellValue(secondentry.getValue()
							.get("interestRate").toString());
					cell4.setCellValue(secondentry.getValue()
							.get("bonusRate").toString());
					cell5.setCellValue(secondentry.getValue()
							.get("totalAmount").toString());
					cell6.setCellValue(secondentry.getValue()
							.get("dealTimesAnalyse").toString());
					cell7.setCellValue(secondentry.getValue()
							.get("successTimesAnalyse").toString());
					cell8.setCellValue(secondentry.getValue()
							.get("dealSalesAnalyse").toString());
					cell9.setCellValue(secondentry.getValue()
							.get("successBuyersAnalyse").toString());
					cell10.setCellValue(secondentry.getValue()
							.get("dealBuyersAnalyse").toString());
					cell11.setCellValue(secondentry.getValue().get("perARUP")
							.toString());
					cell12.setCellValue(secondentry.getValue()
							.get("successrate").toString());
					i++;

				}
			}

		}

		wb.write(os);
		os.flush();
		os.close();
		return os;
	}

}