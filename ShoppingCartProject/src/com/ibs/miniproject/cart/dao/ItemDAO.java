package com.ibs.miniproject.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ibs.miniproject.cart.dbconnect.ConnectionBuilder;
import com.ibs.miniproject.cart.model.ItemModel;

public class ItemDAO implements ItemDAOInterface {

	@Override
	public int checkCart(ItemModel itemmodel) {
		ConnectionBuilder connectionbuilder=new ConnectionBuilder();
		Connection connection=null;
		PreparedStatement preparedstatement=null;
		ResultSet resultset=null;
		try {
			connection =connectionbuilder.buildConnection();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		String itemName=itemmodel.getItemName();
		int userQuantity=itemmodel.getUserQuantity();
	
		int itemQuantity=0;
		int itemPrice=0;

		int returnValue=0;
		
		String selectQuery="SELECT item_price,item_quantity FROM item WHERE item_name=?";
		try {
			preparedstatement=connection.prepareStatement(selectQuery);
			preparedstatement.setString(1, itemName);
			resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
			itemQuantity=resultset.getInt("item_quantity");
			itemPrice=resultset.getInt("item_price");
			   if(itemQuantity==0) 
				returnValue=1;
			   else {
				   returnValue=userQuantity*itemPrice;
				   
				   
				
				
			}
			}
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return returnValue;
	}

	
	

}
