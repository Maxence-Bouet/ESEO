package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
	
	public static Connection Connexion(String name, String user, String password) {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/" + name + "?user=" + user + "&password=" + password);
			return connect;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
}
