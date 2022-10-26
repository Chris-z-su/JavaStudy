﻿/**
 * 
 */
package com.sxt.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Mr.Chris
 *
 */
public class DBUtil {
	// 声明JDBC变量
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	// 静态代码块赋值
	static {
		// IO流读取配置文件中的数据库参数
		// 创建Properties对象
		Properties pro = new Properties();
		// 获取配置文件中的流对象
		InputStream is = DBUtil.class.getResourceAsStream("/db.properties");
		try {
			pro.load(is);// 解析加载配置文件信息
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			// 加载驱动
			Class.forName(driver);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取Connection对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		// 获取链接对象
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 获取PreparedStatement对象
	 * 
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement ps = null;
		try {
			ps = getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

	/**
	 * 获取Statement对象
	 * 
	 * @return
	 */
	public static Statement getStatement() {
		Statement stmt = null;
		try {
			stmt = getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}

	/**
	 * 封装增删改方法
	 * 
	 * @param sql
	 * @param obj
	 * @return
	 */
	public static int executeDML(String sql, Object... obj) {
		// 创建JDBC变量
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 2.获取链接对象
			conn = getConnection();
			conn.setAutoCommit(false);// 设置手动提交事务
			// 4.创建SQL命令对象
			ps = conn.prepareStatement(sql);
			// 5.给占位符赋值
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
			// 6.执行
			int i = ps.executeUpdate();
			if (i > 0) {
				conn.commit();// 提交事务
				return i;
			}
		} catch (Exception e) {
			try {
				conn.rollback();// 回滚事务
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 7.关闭流资源
			closedAll(null, ps, conn);
		}
		return -1;
	}

	/**
	 * 封装关闭资源的方法
	 */
	public static void closedAll(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
