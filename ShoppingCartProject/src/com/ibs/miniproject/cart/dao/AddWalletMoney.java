package com.ibs.miniproject.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ibs.miniproject.cart.dbconnect.ConnectionBuilder;
import com.ibs.miniproject.cart.model.RegisterModel;

public class AddWalletMoney implements AddWalletMoneyInterface {

	@Override
	public void addMoneyToWallet(RegisterModel registermodel) {
		ConnectionBuilder connectionbuilder=new ConnectionBuilder();
		Connection connection=null;
		PreparedStatement preparedstatement=null;
		ResultSet resultset=null;
		int wallet=0;
		String query="SELECT * FROM customer ";
		String username=registermodel.getUserName();
		try {
			connection=connectionbuilder.buildConnection();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			preparedstatement=connection.prepareStatement(query);
			//preparedstatement.setString(1, username);
			resultset=preparedstatement.executeQuery();
			while(resultset.next()) {
				
				wallet=resultset.getInt("walletmoney");
				System.out.println(wallet);
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
