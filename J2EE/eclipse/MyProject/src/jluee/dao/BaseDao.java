package jluee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
	Connection conn;
	java.sql.Statement stmt;

	public void connectToDb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String dbUserName = "root";
		String dbPassWord = "root";
		String url = "jdbc:mysql://localhost:3306/testdb";
		try {
			conn = DriverManager.getConnection(url, dbUserName, dbPassWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
