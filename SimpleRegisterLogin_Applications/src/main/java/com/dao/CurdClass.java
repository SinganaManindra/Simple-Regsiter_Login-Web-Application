package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.ModelTest;
import com.utility.DBconnection;

public class CurdClass implements CURDOperations {

	@Override
	public String insert(ModelTest m) {

		String status = "fail";

		try {

			DBconnection db = new DBconnection();
			Connection con = db.getconnection();
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO studentinfo (username, firstname, lastname, email, password) VALUES (?,?,?,?,?)");

			ps.setString(1, m.getUsername());
			ps.setString(2, m.getFirstname());
			ps.setString(3, m.getLastname());
			ps.setString(4, m.getEmail());
			ps.setString(5, m.getPassword());

			int n = ps.executeUpdate();

			if (n > 0) {
				status = "success";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String select(ModelTest m) {

		String status = "fail";

		try {
			DBconnection db = new DBconnection();
			Connection con = db.getconnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM studentinfo WHERE username=? AND password=?");

			ps.setString(1, m.getUsername());
			ps.setString(2, m.getPassword());

			ResultSet rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				count++;
			}
			if (count > 0) {
				status = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String update(ModelTest m) {

		String status = "fail";

		try {
			DBconnection db = new DBconnection();
			Connection con = db.getconnection();

			PreparedStatement ps = con.prepareStatement(
					"UPDATE studentinfo SET firstname=?, lastname=?, email=?, password=? WHERE username=?");

			ps.setString(1, m.getFirstname());
			ps.setString(2, m.getLastname());
			ps.setString(3, m.getEmail());
			ps.setString(4, m.getPassword());
			ps.setString(5, m.getUsername());

			int n = ps.executeUpdate();

			if (n > 0) {
				status = "success";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String delete(ModelTest m) {
	    String status = "fail";

	    try {
	    	DBconnection db = new DBconnection();
			Connection con = db.getconnection();

	        PreparedStatement ps = con.prepareStatement(
	            "DELETE FROM users WHERE username=?"
	        );

	        ps.setString(1, m.getUsername());

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            status = "success";
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
}