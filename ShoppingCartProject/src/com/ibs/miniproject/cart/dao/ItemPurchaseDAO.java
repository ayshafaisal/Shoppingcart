package com.ibs.miniproject.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.ibs.miniproject.cart.model.RegisterModel;
import com.ibs.miniproject.cart.dbconnect.ConnectionBuilder;
import com.ibs.miniproject.cart.model.ItemModel;
import com.ibs.miniproject.cart.model.LoginModel;

public class ItemPurchaseDAO implements ItemPurchaseDAOInterface{

	@Override
	
	public int makePurchase(ItemModel itemmodel) {
	  ConnectionBuilder connectionbuilder=new ConnectionBuilder();
	  Connection connection=null;
	  ResultSet resultset=null;
	  PreparedStatement preparedstatement=null;
	  
	  LoginModel loginmodel=new LoginModel();
	  try {
		  connection=connectionbuilder.buildConnection();
	  }catch(Exception e) {
		  System.out.println(e.getMessage());
	  }
        String username=loginmodel.getUserName();
        int quantity=itemmodel.getUserQuantity();
        String itemName=itemmodel.getItemName();
        int walletMoney=0;
        int newWalletMoney=0;
        int price=0;
        int totalPrice=0;
        String query="SELECT item_price FROM item WHERE item_name=?";
        String query2="SELECT walletmoney FROM customer WHERE username=?";
        String query3="INSERT INTO customer(walletmoney)VALUES(?)";
        try {
        	preparedstatement=connection.prepareStatement(query);
        	preparedstatement.setString(1, itemName);
        	resultset=preparedstatement.executeQuery();
        	if(resultset.next()) {
        		price=resultset.getInt("item_price");
        	    totalPrice=price*quantity;
        	    preparedstatement=connection.prepareStatement(query2);
        	    preparedstatement.setString(1, username);
        	    resultset=preparedstatement.executeQuery();
        	    if(resultset.next()) {
        	    	walletMoney=resultset.getInt("walletmoney");
        	    	if(walletMoney>=totalPrice) {
        	    	newWalletMoney=walletMoney-totalPrice;
        	    	}else {
        	    		System.out.println("insufficient cash");
        	    	}
        	    	try {
        	    		preparedstatement=connection.prepareStatement(query3);
        	    		preparedstatement.setInt(1, newWalletMoney);
        	    		int value=preparedstatement.executeUpdate();
        	    		if(value==1) {
        	    			System.out.println("payment successful");
        	    		}else {
        	    			System.out.println("paymentt error .please try again");
        	    		}
        	    	}catch(Exception e) {
        	    		System.out.println(e.getMessage());
        	    	}
        	    	
        	    }
        	    
        	}else {
        		System.out.println("no item found");
        	}
        	
        	
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
   	  
		return totalPrice ;
	}
	

}
