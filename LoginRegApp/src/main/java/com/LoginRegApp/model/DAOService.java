package com.LoginRegApp.model;

import java.sql.ResultSet;

//Abstraction
public interface DAOService {
	public void connectDB();

	public boolean verifyCredentials(String email, String password);

	public void saveRegistration(String name, String city, String mobile, String email);

	public ResultSet listAll();

	public void deleteReg(String email);

	public void updateRegistration(String mobile, String email);

}
