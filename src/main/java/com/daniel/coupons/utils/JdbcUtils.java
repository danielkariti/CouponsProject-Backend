package com.daniel.coupons.utils;
//package com.shlomi.coupons.utils;
//
//
//import java.sql.*;
//
//public class JdbcUtils {
//
//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static Connection getConnection() throws SQLException {
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/couponsv3?useSSL=false&serverTimezone=UTC", "root",
//				"shlomi232");
//		return connection;
//	}
//
//	public static void closeResources(Connection connection, PreparedStatement preparedStatement) {
//		try {
//			if (connection != null) {
//				connection.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		try {
//			if (preparedStatement != null) {
//				preparedStatement.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
//		closeResources(connection, preparedStatement);
//		try {
//			if (resultSet != null) {
//				resultSet.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//}