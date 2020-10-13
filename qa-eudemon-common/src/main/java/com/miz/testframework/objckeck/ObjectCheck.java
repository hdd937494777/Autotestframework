package com.miz.testframework.objckeck;


import au.com.bytecode.opencsv.CSVReader;
import com.miz.testframework.objckeck.comparers.Comparer;
import com.miz.testframework.objckeck.comparers.ConditionComparer;
import com.miz.testframework.objckeck.comparers.NoCheckComparer;
import com.miz.testframework.objckeck.comparers.SimpleComparer;
import com.miz.testframework.util.StringUtil;
import org.apache.ibatis.ognl.DefaultMemberAccess;
import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 以文件方式校验对象
 */
public class ObjectCheck {

	private static final Logger logger            = LoggerFactory
			.getLogger(ObjectCheck.class);

	private static final int      COLUMN_FIELD      = 1;
	private static final int      COLUMN_FLAG       = 2;
	private static final int      COLUMN_EXP        = 3;
	/**  合法数据文件最少列数，即只含一列校验期望值 */
	private static final int      COLUMN_LEAST      = 4;

	private static final int      ROW_CONTENT_BEGIN = 1;

	private static final String   FLAG_CONDITION    = "C";

	/** 校验器 */
	private Map<String, Comparer> comparers         = new HashMap<String, Comparer>();

	public ObjectCheck() {
		init();
	}


	/**
	 * 初始化
	 *
	 * <p>
	 * 加载默认校验器:N、Y、C
	 * </p>
	 *
	 */
	private void init() {
		comparers.put("N", new NoCheckComparer());
		comparers.put("Y", new SimpleComparer());
		comparers.put(FLAG_CONDITION, new ConditionComparer());
	}



	/**
	 * 校验指定列的期望值
	 *
	 * @param csvPath   数据文件路径，resources下的相对路径
	 * @param actual    校验对象
	 * @param index     期望值的列序号，基数默认为0
	 * @return
	 */
	public boolean check(String csvPath, Object actual, int index) throws UnsupportedEncodingException {

		List<String[]> rows = getCsvDataList(csvPath);
		// 第一行为csv列表头，无实际内容
		if (rows == null || rows.isEmpty() || rows.size() < ROW_CONTENT_BEGIN + 1) {
			throw new IllegalArgumentException("[" + csvPath + "]\n\t csv文件内容未读取到或为空.");
		}

		int rowCount = rows.size();
		for (int i = ROW_CONTENT_BEGIN; i < rowCount; i++) {
			String[] row = rows.get(i);
			if (row == null || row.length < COLUMN_LEAST + index
					|| StringUtil.isEmpty(row[COLUMN_FLAG])) {
				throw new IllegalArgumentException("[" + csvPath + "]\n\t csv文件内容不合法.[row " + i);
			}

			Comparer comparer = comparers.get(row[COLUMN_FLAG]);
			if (comparer == null) {
				throw new IllegalArgumentException("[" + csvPath + "]\n\t 指定flag无相应检验器.[row " + i);
			}

			Object actualField = null;
			try {
				actualField = getProperty(actual, row[COLUMN_FIELD]);
			} catch (OgnlException e) {
				throw new IllegalArgumentException("[" + csvPath + "]\n\t [row " + i
						+ "] 使用获取属性值失败: " + row[COLUMN_FIELD]);
			}

			if (!comparer.compare(row[COLUMN_EXP + index], actualField)) {
				throw new IllegalArgumentException("[" + csvPath + "]\n\t 校验失败[row " + i
						+ ",expectCol " + index + "]"
						+ row[COLUMN_FIELD] + " 期望值:"
						+ row[COLUMN_EXP + index] + ",实际值:"
						+ String.valueOf(actualField));
			}
		}
		return true;
	}

	/**
	 * 使用Ongl获取对象中属性值
	 * @param object
	 * @param ognlExpression
	 * @return
	 * @throws OgnlException
	 */
	private Object getProperty(Object object, String ognlExpression) throws OgnlException {

		OgnlContext ognlContext = new OgnlContext();
		ognlContext.setMemberAccess(new DefaultMemberAccess(true));
		Object ognlExprObj = Ognl.parseExpression(ognlExpression);
		return Ognl.getValue(ognlExprObj, ognlContext, object);

	}

	/**
	 * 获取CSV文件内容
	 *
	 * @param csvPath resources下的相对路径
	 * @return List<String[]>
	 */
	@SuppressWarnings("unchecked")
	private List<String[]> getCsvDataList(String csvPath) throws UnsupportedEncodingException {

		if (StringUtil.isEmpty(csvPath)) {
			logger.error("指定csv文件路径为空.");
			return null;
		}

		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(csvPath);
		if (is == null) {
			String err = "指定csv文件路径[" + csvPath + "]未找到文件.";
			logger.error(err);
			return null;
		}

		InputStreamReader isr = new InputStreamReader(is,"UTF-8");
		CSVReader csvReader = new CSVReader(isr);
		try {
			return (List<String[]>) csvReader.readAll();
		} catch (IOException e) {
			logger.error("csv文件读取失败.", e);
		}

		return null;
	}

}