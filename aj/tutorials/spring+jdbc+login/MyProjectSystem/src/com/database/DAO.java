package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.models.User;

public class DAO {
	String driverString = "com.mysql.jdbc.Driver";
	String dbConString = "jdbc:mysql://localhost:3306/user_database";

	String username = "root";
	String password = "admin";

	Connection con;

	public User getUserBasedOnName(User u) {
		Statement stmt;
		try {
			User db_user;
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select  * from user_details where user_name = \"" + u.getName() + "\"");
			while (rs.next()) {
				db_user = new User();
				db_user.setId(rs.getInt("id_user_details"));
				db_user.setPass(rs.getString("user_pass"));
				db_user.setName(rs.getString("user_name"));
				return db_user;
			}
			return null;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public void connect() {
		try {
			Class.forName(driverString);
			con = DriverManager.getConnection(dbConString, username, password);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
