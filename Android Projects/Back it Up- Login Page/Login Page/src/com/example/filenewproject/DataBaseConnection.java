package com.example.filenewproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

	Connection connect = null;
	
	boolean result = false;
	public Connection getDataBaseConnection(){
		if(connect == null){
			try {

				Class.forName("com.mysql.jdbc.Driver");// loading MySQL driver
				connect = DriverManager.getConnection("jdbc:mysql://cmpe277.c38qsf0avgvg.us-west-1.rds.amazonaws.com:3306/CMPE277?user=root&password=rootcmpe277");

				//Set up connection with DB, username, password
			} catch (Exception e) {
				
				System.out.println("Exception in Login::"+e.getMessage());
				e.printStackTrace();
			}
		}
		return connect;
	}

}
