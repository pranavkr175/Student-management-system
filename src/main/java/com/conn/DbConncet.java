package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConncet {

	private static Connection con=null;
	
	public static Connection getCon() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","1234" );
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}
	
}
