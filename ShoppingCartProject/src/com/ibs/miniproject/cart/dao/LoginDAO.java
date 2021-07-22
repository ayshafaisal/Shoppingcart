package com.ibs.miniproject.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ibs.miniproject.cart.dbconnect.ConnectionBuilder;
import com.ibs.miniproject.cart.model.LoginModel;


public class LoginDAO implements LoginDAOInterface {

	@Override
	public int processLoginData(LoginModel loginmodel) {
		ConnectionBuilder connectionbuilder=new ConnectionBuilder();
		Connection connection=null;
		PreparedStatement preparedstatement=null;
		ResultSet resultset=null;
		int returnValue=0;
		try {
			connection=connectionbuilder.buildConnection();
			
		}catch(Exception e) {
			System.out.println("kutta");
		}
		String username=loginmodel.getUserName();
		String password=loginmodel.getPassword();
		String passworddb="";
		String selectQuery="SELECT username,password FROM customer WHERE username=?";
		
		try {
			preparedstatement=connection.prepareStatement(selectQuery);
			preparedstatement.setString(1, username);
			resultset=preparedstatement.executeQuery();
			if(resultset.next())
				passworddb=resultset.getString("password");
			    if(passworddb.equals(password))
			    	returnValue=5;
			else {
				returnValue=6;
			}
				
			
		}catch(Exception e) {
			System.out.println("patta");
		}
		finally {
			try {
				resultset.close();
				preparedstatement.close();
				connection.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return returnValue;
	}

}
