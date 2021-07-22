package com.ibs.miniproject.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ibs.miniproject.cart.dbconnect.ConnectionBuilder;
import com.ibs.miniproject.cart.model.ItemModel;

public class ItemDetailsDAO implements ItemDetailsDAOInterface{

	@Override
	public void showItemList(ItemModel itemmodel) {
		   ConnectionBuilder connectionbuilder=new ConnectionBuilder();
		   Connection connection=null;
		   PreparedStatement preparedstatement=null;
		   ResultSet resultset=null;
		   String item="";
		   int price=0;
		   String showQuery="SELECT * FROM item";
		   try {
			   connection=connectionbuilder.buildConnection();
		   }catch(Exception e) {
			   System.out.println(e.getMessage());
		   }
		   try {
			   preparedstatement=connection.prepareStatement(showQuery);
			   resultset=preparedstatement.executeQuery();
			   System.out.println("ITEM NAME \t  ITEM PRICE");
			   
			   while(resultset.next()) {
				  item= resultset.getString("item_name");
				   price=resultset.getInt("item_price");
				   System.out.println(item +" \t "+price);
			   }
		   }catch(Exception e) {
			   System.out.println(e.getMessage());
		   }
		   
		
	}
	

}
