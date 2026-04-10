package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	public Connection getconnection() {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");

			System.out.println("Database Connected");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
