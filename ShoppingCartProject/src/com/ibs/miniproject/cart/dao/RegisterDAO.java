package com.ibs.miniproject.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ibs.miniproject.cart.dbconnect.ConnectionBuilder;
import com.ibs.miniproject.cart.model.RegisterModel;

public class RegisterDAO implements RegisterDAOInterface {

	@Override
	public int registerUserDetails(RegisterModel registermodel) {
		PreparedStatement preparedstatement=null;
		Connection connection=null;
		ResultSet resultset=null;
		ConnectionBuilder connectionbuilder=new ConnectionBuilder();
		
		int returnValue=0;
		int count=0;
	
		try {
			connection=connectionbuilder.buildConnection();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		String name=registermodel.getName();
		String username=registermodel.getUserName();
		String password=registermodel.getPassword();
		String profession=registermodel.getProfession();
		String gender=registermodel.getGender();
		String insertQuery="INSERT INTO customer(customer_name,username,password,profession,gender)VALUES(?,?,?,?,?)";
		String selectQuery="SELECT username FROM customer WHERE username=?";
		try {
			preparedstatement=connection.prepareStatement(selectQuery);
			preparedstatement.setString(1, username);
			resultset=preparedstatement.executeQuery();
			if(resultset.next())
				returnValue=13;
		      else{
				preparedstatement=connection.prepareStatement(insertQuery);
				preparedstatement.setString(1, name);
				preparedstatement.setString(2, username);
				preparedstatement.setString(3, password);
				preparedstatement.setString(4, profession);
				preparedstatement.setString(5, gender);
				count=preparedstatement.executeUpdate();
				if(count==1) {
					returnValue=14;
				}else {
					returnValue=15;
				}
		}
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
		return returnValue;
	

}
}