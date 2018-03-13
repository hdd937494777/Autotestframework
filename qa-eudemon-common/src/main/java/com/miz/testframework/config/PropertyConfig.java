package com.miz.testframework.config;


import com.miz.testframework.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 启动参数属性配置
 * <p>
 * Create at：2017年7月12日 上午10:46:38
 *
 * @author chuwenjun
 */

public class PropertyConfig {

	/**
	 * 配置中的表分割符
	 */
	public static String DB_TABLENAME_SPIT_REGEX = ",";

	/**
	 * DB配置数据源文件
	 */
	public static final String DB_CONF_FILE = "dbconf_file";


	/** 配置文件的目录 */
	/**
	 * db.conf的目录
	 */
	public static final String DB_CONF_DIR = "config/dbConf/";


	/**
	 * 配置项计数，计算出共有多少组配置
	 */
	public static int confNumber = -1;

	/**
	 * 配置项缓存
	 */
	public static Configration testConfigs = null;

	private static String dbconfFile;

	protected static Logger logger = LoggerFactory.getLogger(PropertyConfig.class);


	/**
	 * 加载配置文件参数,根据配置项加载不同配置信息
	 */
	public static synchronized void initDBConfigs() {
		// 将配置项入缓存，只加载一次
		if (null == testConfigs) {
			testConfigs = ConfigrationFactory.getConfigration();
		}

		if (null != testConfigs) {
			dbconfFile = testConfigs.getPropertyValue(DB_CONF_FILE);

			if (StringUtil.isNotBlank(dbconfFile)) {
				dbconfFile = DB_CONF_DIR + dbconfFile.trim();
				ConfigrationFactory.loadFromConfig(dbconfFile);
			} else {
				dbconfFile = ConfigrationFactory.AUTO_CONFIG_BASE_DIR + ConfigrationFactory.AUTO_CONFIG_FILE_NAME;
				logger.info("配置项中没有 [dbconf_file]！");
			}

			confNumber = 1;
			// 配置项计数，计算出共有多少组配置
			while (testConfigs.getPropertyValue("ext" + confNumber + "_db_tablename") != null) {
				confNumber++;
			}
		}

	}


	/**
	 * 读取指定数据库配置项
	 */
	public static DBConfig getDBConfig(String tableName) {
		DBConfig dbconfig = new DBConfig();
		String url = "";
		String username = "";
		String password = "";
		String schema = "";

		/* 这里修改为TABLE大小写不敏感 */
		if (StringUtil.isNotBlank(tableName)) {
			tableName = tableName.toUpperCase();
		}

			for (int i = 1; i < confNumber; i++) {
				if (matchTable(tableName, testConfigs.getPropertyValue("ext" + i + "_db_tablename"))) {
					url = testConfigs.getPropertyValue("ext" + i + "_db_url");
					username = testConfigs.getPropertyValue("ext" + i + "_db_username");
					password = testConfigs.getPropertyValue("ext" + i + "_db_password");
					schema = testConfigs.getPropertyValue("ext" + i + "_db_schema");
					break;
				}


			}

			dbconfig.setConnectionUrl(url);
			dbconfig.setUsername(username);
			dbconfig.setPassword(password);
			dbconfig.setSchema(schema);

			return dbconfig;
		}


	/**
	 * 如果tableName包含在tableNameConfig中，则返回 true
	 *
	 * @param tableName
	 * @param tableNameConfig
	 * @return
	 */
	private static boolean matchTable(String tableName, String tableNameConfig) {
		if (StringUtil.isBlank(tableNameConfig) || StringUtil.isBlank(tableName)) {
			return false;
		}
		String[] tables = tableNameConfig.toUpperCase().split(DB_TABLENAME_SPIT_REGEX);
		for (String table : tables) {
				if (table.equals(tableName)) {
					return true;
				}
		}
		return false;
	}

}

