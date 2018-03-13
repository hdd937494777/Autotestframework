package com.miz.testframework.config;

/**
 * 存取DB配置参数
 *
 * Created by chuwenjun on 2017/7/24.
 */
public class DBConfig {

    /* 链接路径 */
    private String connectionUrl;
    /* 用户名 */
    private String username;
    /* 密码 */
    private String password;
    /* Schema */
    private String schema;

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

}
