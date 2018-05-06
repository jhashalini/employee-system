package com.ems.dao;

import java.sql.*;

class DatabaseConnection {

	private static Connection _connection = null;

	private DatabaseConnection() {
	}

	static {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			_connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "root");
		} catch (Exception e) {
			System.out.println("Exception occured while connectin to database " + e);
		}
	}

	public static Connection getConnection() {
		return _connection;
	}
}