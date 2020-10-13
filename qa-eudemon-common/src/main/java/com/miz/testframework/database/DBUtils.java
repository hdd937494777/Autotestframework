package com.miz.testframework.database;

import au.com.bytecode.opencsv.CSVReader;
import com.miz.testframework.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

import static com.miz.testframework.database.DataCompare.compareTableData;
import static com.miz.testframework.database.DataCompare.composeQuerySql;


/**
 * 数据库相关工具类
 *
 */
public class DBUtils {

	private static ThreadLocal<Integer> argsIndex = new ThreadLocal();

	protected static Logger logger = LoggerFactory.getLogger(DBUtils.class);

	public static boolean DBCheckWithoutCondition(String path, int index) throws UnsupportedEncodingException {
		argsIndex.set(Integer.valueOf(0));
		return DBCheckWithoutConditionImpl(path, index);
	}

	private static boolean DBCheckWithoutConditionImpl(String path, int index) throws UnsupportedEncodingException {
		String[] tableNameAndCondition = getTableNameAndConditionWithCsvCFlag(path, index);

		String tableName = tableNameAndCondition[0];
		String condition = tableNameAndCondition[1];
		if ((StringUtil.isBlank(tableName)) || (StringUtil.isBlank(condition))) {
			return false;
		}
		return DBCheck(new String[]{path}, new String[]{tableName}, new String[]{condition}, index);
	}

	private static String[] getTableNameAndConditionWithCsvCFlag(String path, int index) {
		if (StringUtil.isBlank(path)) {
			return null;
		}
		String tableName = "";
		String condition = "";
		InputStream is = null;
		InputStreamReader isr = null;
		CSVReader csvr = null;
		String[] rowdata;
		try {
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
			if (null == is) {
				logger.error("加载文件失败,检查路径是否正确 [" + path + "]");
			}
			isr = new InputStreamReader(is,"UTF-8");
			csvr = new CSVReader(isr);
			List tableList = csvr.readAll();

			int rows = tableList.size();
			if (rows <= 1) {
				return null;
			}
			for (int i = 1; i < rows; i++) {
				rowdata = (String[]) tableList.get(i);
				if (1 == i) {
					tableName = rowdata[0].toUpperCase();
					if (StringUtil.isBlank(tableName)) {
						return null;
					}
				}
				String colName = rowdata[1];
				String flag = rowdata[2];
				String expVal = rowdata[(2 + index)];
				if (flag.equalsIgnoreCase("C")) {
					if (!StringUtil.isBlank(condition)) {
						condition = condition + " and ";
					}
					condition = condition + colName + "='" + expVal + "'";
				}
			}

			if (StringUtil.isEmpty(condition))
				return null;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (null != csvr) {
					csvr.close();
				}
				if (null != isr)
					isr.close();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return new String[] { tableName, condition };
	}


	public static boolean DBCheck(String[] path, String[] tableName, String[] condition, int id)  {
		return DBChecking(path, tableName, condition, id);
	}

	public static boolean DBChecking(String[] path, String[] tableName, String[] condition, int id) {
		boolean isSuccess = true;
		if ((path.length != tableName.length) || (path.length != condition.length)) {
			logger.error("参数错误");
			return false;
		}

		String executeSql = "";
		HashMap resultmap = new HashMap();
		List retMsgList = new ArrayList();
		for (int i = 0; i < path.length; i++) {
			try {
				executeSql = composeQuerySql(path[i], tableName[i], condition[i]);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			resultmap = compareTableData(path[i], executeSql, tableName[i], id);



			if (!resultmap.isEmpty()) {
				retMsgList.add(resultmap);
				isSuccess = false;
			}
			Collection c = (Collection) resultmap.keySet();
			Iterator j = c.iterator();
			while (j.hasNext()) {
				Object key = j.next();
				Object value = resultmap.get(key);
				logger.error(key + "\t" + value);
			}
		}

		return isSuccess;
	}


	public static String getStringValue(String tableName, String sql) {
		String value = null;

		DBConn conn = new DBConn();
		ResultSet resultSet = conn.executeQuery(tableName, sql);
		try {
			if (!resultSet.next())
				return null;
			value = resultSet.getString(1);
		} catch (SQLException e) {
			logger.error("数据库操作出错。", e);
		} finally {
			conn.close();
		}

		return value;
	}

	public static int getCountValue(String tableName, String sql) {
		int value = 0;

		DBConn conn = new DBConn();
		ResultSet resultSet = conn.executeQuery(tableName, sql);
		try {
			if (!resultSet.next())
				return 0;
			value = Integer.valueOf(resultSet.getString(1));
		} catch (SQLException e) {
			logger.error("数据库操作出错。", e);
		} finally {
			conn.close();
		}

		return value;
	}

	public static int updateDB(String tableName, String sql) {
		DBConn conn = new DBConn();
		int resultSet = 0;
		try {
			resultSet = conn.executeUpdate(tableName, sql);
			logger.info("DB操作成功："+ sql);
		} catch (Exception e) {
			logger.error("数据库操作出错。", e);
			return -1;
		} finally {
			conn.close();
		}

		return resultSet;
	}

}
