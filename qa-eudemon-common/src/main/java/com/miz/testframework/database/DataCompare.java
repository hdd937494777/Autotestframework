package com.miz.testframework.database;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


/**
 * 数据对比，逐行对比csv数据与查询结果是否一致
 *
 * Created by chuwenjun on 2017/7/24.
 */
public class DataCompare {
	private static List<?> dataExps = null;
	private static int FLAG_COLUMN = 2;
	private static int COLS_COLUMN = 1;
	private static int EXPSTAR_COLUMN = 2;

	public static String composeQuerySql(String path, String tableName, String condition) throws UnsupportedEncodingException {
		ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
		strat.setType(DataExp.class);
		String[] columns = { "tableName", "colsName", "flag", "exp" };
		strat.setColumnMapping(columns);
		CsvToBean csv = new CsvToBean();
		String excuteSql = "";
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		InputStreamReader isr = new InputStreamReader(is,"UTF-8");

		dataExps = csv.parse(strat, isr);
		try {
			if (null != isr)
				isr.close();
		} catch (Exception e) {
		}
		String clos = "";
		for (int i = 1; i < dataExps.size(); i++) {
			if (!"N".equals(((DataExp) dataExps.get(i)).getFlag()))
				clos = clos + "," + ((DataExp) dataExps.get(i)).getColsName();
		}
		clos = clos.replaceFirst(",", "");

		excuteSql = "SELECT " + clos + " FROM " + tableName + " where " + condition;

		return excuteSql;
	}

	public static HashMap<String, String> compareTableData(String path, String executeSql, String tableName, int id) {
		String act = "";
		String exp = "";
		HashMap message = new HashMap();
		InputStreamReader isr = null;
		CSVReader csvr = null;
		DBConn conn = null;
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);

			isr = new InputStreamReader(is,"UTF-8");
			csvr = new CSVReader(isr);

			List tableList = csvr.readAll();

			int rows = tableList.size();

			conn = new DBConn();
			ResultSet actualTable = conn.executeQuery(tableName,executeSql);

			if (actualTable.next()) {
				for (int d = 1; d < rows; d++) {
					String[] rowdata = (String[]) tableList.get(d);

					if ((!"N".equals(rowdata[FLAG_COLUMN])) && (!"C".equals(rowdata[FLAG_COLUMN]))) {
							exp = rowdata[(EXPSTAR_COLUMN + id)];
							Object tmp = actualTable.getObject(rowdata[COLS_COLUMN]);
							if (tmp != null)
								act = actualTable.getString(rowdata[COLS_COLUMN]);
							else
								act = "null";
							if (!exp.equals(act)) {
								message.put(Integer.toString(d),
										"检查表:" + tableName + " <BR> " + rowdata[COLS_COLUMN] + " "
												 + " <BR> id=[" + id + "] 期望值=" + exp + " 实际值="
												+ act);
							}

					}

				}

			} else {
				message.put("NONE", "检查表：" + tableName + "出错！未查询到数据, sql=[" + executeSql + "]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != conn) {
					conn.close();
				}
				if (null != csvr) {
					csvr.close();
				}
				if (null != isr)
					isr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return message;
	}
}
