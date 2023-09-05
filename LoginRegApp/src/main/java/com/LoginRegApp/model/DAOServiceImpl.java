package com.LoginRegApp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
//	private Connection con;
	private Statement stmnt;

	@Override
	public void connectDB() {
		try {
			// Without this Driver we can't write Data in DB/ It interacts with Database.
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb", "root", "root");
			stmnt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifyCredentials(String email, String password) {
		try {
			ResultSet result = stmnt
					.executeQuery("SELECT * from login where email='" + email + "' and password= '" + password + "'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void saveRegistration(String name, String city, String mobile, String email) {
		try {
			stmnt.executeUpdate(
					"INSERT into registration values('" + name + "','" + city + "','" + mobile + "','" + email + "')");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ResultSet listAll() {
		try {
			ResultSet result = stmnt.executeQuery("SELECT * from registration");
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void deleteReg(String email) {
		try {
			stmnt.executeUpdate("DELETE FROM registration WHERE email= '" + email + "'");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateRegistration(String mobile, String email) {
		try {
			stmnt.executeUpdate("UPDATE registration set mobile='" + mobile + "' where email= '" + email + "'");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
