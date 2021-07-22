package com.ibs.miniproject.cart.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBuilder {
	public Connection buildConnection(){
		Connection connection=null;
		String url="jdbc:postgresql://localhost:5432/cart";
		String userName="postgres";
		String password="1234";
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection(url, userName, password);
		}catch(ClassNotFoundException cl) {
			System.out.println(cl.getCause());
		}
		catch(Exception e) {
			System.out.println("exception occured zainab"+e.getMessage());
		}
		return connection;

}
}
