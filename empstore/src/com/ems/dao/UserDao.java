package com.ems.dao;

import java.sql.*;

public class UserDao {

	public User getUserByUsername(String username, String password) {

		Connection connection = DatabaseConnection.getConnection();
		User userObject = null;
		String sql = "select * from user where username =? and password = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					String user = rs.getString(1);
					String pass = rs.getString(2);

					userObject = new User();
					userObject.setUsername(user);
					userObject.setPassword(pass);

					System.out.println("User retrieved from database : " + user);

				}

			} else {
				System.out.println("No user found in the database with username " + username);
			}

		} catch (SQLException e) {
		}
		return userObject;
	}

	/**
	 * 
	 * This validates the user
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean validateLogin(String username, String password) {

		Connection connection = DatabaseConnection.getConnection();

		String sql = "select count(*) from user where username =? and password = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					int noOfUser = rs.getInt(1);
					if (noOfUser > 0) {
						System.out.println("user found in the database,,");
						return true;
					} else {
						return false;
					}
				}

			} else {
				System.out.println("No user found in the database with username " + username);
			}

		} catch (SQLException e) {
		}

		return false;
	}

	public boolean saveUser(String username, String password) {

		String sql = "insert into user values (?,?)";

		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			int noOfRowsInserted = ps.executeUpdate();
			System.out.println("No of user inserted into user table : " + noOfRowsInserted);
			if (noOfRowsInserted > 0)
				return true;

		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
		return false;
	}

	public boolean saveUserProfile(String username, String name, String email, String phone, String gender) {

		String sql = "insert into user_profile (name, email, phone, gender, username) values (?,?,?,?,?)";

		try {
			Connection connection = DatabaseConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, gender);
			ps.setString(5, username);

			int noOfRowsInserted = ps.executeUpdate();
			System.out.println("No of user inserted into user_profile table : " + noOfRowsInserted);

			if (noOfRowsInserted > 0) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}

		return false;

	}

}
