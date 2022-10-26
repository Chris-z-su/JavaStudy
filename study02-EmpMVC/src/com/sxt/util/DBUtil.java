/**
 * 
 */
package com.sxt.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Mr.Chris
 *
 */
public class DBUtil {
	// ����JDBC����
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	// ��̬����鸳ֵ
	static {
		// IO����ȡ�����ļ��е����ݿ����
		// ����Properties����
		Properties pro = new Properties();
		// ��ȡ�����ļ��е�������
		InputStream is = DBUtil.class.getResourceAsStream("/db.properties");
		try {
			pro.load(is);// �������������ļ���Ϣ
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			// ��������
			Class.forName(driver);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡConnection����
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		// ��ȡ���Ӷ���
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * ��ȡPreparedStatement����
	 * 
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement ps = null;
		try {
			ps = getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	/**
	 * ��ȡStatement����
	 * 
	 * @return
	 */
	public static Statement getStatement() {
		Statement stmt = null;
		try {
			stmt = getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}

	/**
	 * ��װ��ѯ����
	 * 
	 * @param t
	 * @param sql
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> executeSelect(T t, String sql, Object... obj) {
		// ����JDBC����
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// ��������
		List<T> list = new ArrayList<T>();
		try {
			// ��ȡ����
			conn = getConnection();
			// ����SQL����
			// ����SQL�������
			ps = getPreparedStatement(sql);
			// ��ռλ����ֵ
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i + 1, obj[i]);
				}
			}
			// ִ��
			rs = ps.executeQuery();
			// ��ȡ������ı�ṹ
			ResultSetMetaData rm = rs.getMetaData();
			// ��ȡ�ֶ�����
			int count = rm.getColumnCount();
			// ����
			while (rs.next()) {
				Class<? extends Object> cla = t.getClass();// ��ȡʵ����������
				Object os = cla.newInstance();// ����ʵ�������
				// ����
				for (int i = 0; i < count; i++) {
					// ��ȡ�ֶ���
					String columnName = rm.getColumnName(i + 1);
					// ƴ��set������
					String methodName = "set" + columnName.substring(0, 1).toUpperCase()
							+ columnName.substring(1).toLowerCase();
					// ��ȡ�ֶ�����
					String columnClassName = rm.getColumnClassName(i + 1);
					// //��ȡ��������
					Method m = cla.getMethod(methodName, Class.forName(columnClassName));
					m.invoke(os, rs.getObject(columnName));
				}
				list.add((T) os);
			}
			// ���ؽ����
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �ر���Դ
			DBUtil.closedAll(rs, ps, conn);
		}
		return null;
	}

	/**
	 * ��װ��ɾ�ķ���
	 * 
	 * @param sql
	 * @param obj
	 * @return
	 */
	public static int executeDML(String sql, Object... obj) {
		// ����JDBC����
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 2.��ȡ���Ӷ���
			conn = getConnection();
			conn.setAutoCommit(false);// �����ֶ��ύ����
			// 4.����SQL�������
			ps = conn.prepareStatement(sql);
			// 5.��ռλ����ֵ
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
			// 6.ִ��
			int i = ps.executeUpdate();
			if (i > 0) {
				conn.commit();// �ύ����
				return i;
			}
		} catch (Exception e) {
			try {
				conn.rollback();// �ع�����
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			// 7.�ر�����Դ
			closedAll(null, ps, conn);
		}
		return -1;
	}

	/**
	 * ��װ�ر���Դ�ķ���
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
