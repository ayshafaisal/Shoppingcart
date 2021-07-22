package com.ibs.miniproject.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ibs.miniproject.cart.dbconnect.ConnectionBuilder;
import com.ibs.miniproject.cart.model.RegisterModel;

public class ViewWalletMoney implements ViewWalletMoneyInterface{

	@Override
	public int getWalletMoney(RegisterModel registermodel) {
	ConnectionBuilder connectionbuilder=new ConnectionBuilder();
	PreparedStatement preparedstatement=null;
	Connection connection=null;
	ResultSet resultset=null;
	int walletMoney=20;
	String query="SELECT walletmoney FROM customer WHERE username=?";
	String username=registermodel.getUserName();
	try {
		System.out.println("hello ");
		connection=connectionbuilder.buildConnection();
		
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	try {
		preparedstatement=connection.prepareStatement(query);
		preparedstatement.setString(1, username);
		resultset=preparedstatement.executeQuery();
		if(resultset.next()) {
			System.out.println("hello if");
			 walletMoney=resultset.getInt("walletmoney");
			System.out.println("Your current balance is"+walletMoney);
		}else {
			System.out.println("hello else");
		}
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
	
	
		return walletMoney;
	}

}
