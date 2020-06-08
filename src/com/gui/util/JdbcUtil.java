package com.gui.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Jdbc链接工具类
 */
public class JdbcUtil {

    public static final ComboPooledDataSource ds = new ComboPooledDataSource();

    static {
        //加载连接数据库的信息
        try {
            //从配置文件中读取数据库连接信息
            InputStream is = new FileInputStream("jdbcInfo.properties");
            Properties porp = new Properties();
            porp.load(is);
            is.close();
            //获取连接数据库信息
            String user = porp.getProperty("user");
            String pwd = porp.getProperty("pwd");
            String url = porp.getProperty("url");
            String driver = porp.getProperty("driver");
            //设置链接库的信息
            ds.setUser(user);
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setPassword(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取链接
     */
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭链接
     */
    public static void release(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
