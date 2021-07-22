package com.ibs.miniproject.cart.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ibs.miniproject.cart.exception.LoginException;
import com.ibs.miniproject.cart.exception.RegisterException;
import com.ibs.miniproject.cart.model.ItemModel;
import com.ibs.miniproject.cart.model.LoginModel;
import com.ibs.miniproject.cart.model.RegisterModel;
import com.ibs.miniproject.cart.service.ItemService;
import com.ibs.miniproject.cart.service.LoginService;
import com.ibs.miniproject.cart.service.RegisterService;

public class MainClass {
	public static void main(String args[]) throws RegisterException {
		RegisterModel registermodel=new RegisterModel();
		RegisterService registerservice=new RegisterService();
		  LoginModel loginmodel=new LoginModel();
	       LoginService loginservice=new LoginService();
	       ItemModel itemmodel=new ItemModel();
	       ItemService itemservice=new ItemService();
           BufferedReader bufferedreader=new BufferedReader(new InputStreamReader(System.in));
           System.out.println("Welcome!");
           System.out.println("press 1 if you are a new user");
           System.out.println("press 2 if you are already an existing user");
           System.out.println("enter your choice");
           int option=0;
           try {
			option=Integer.parseInt(bufferedreader.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           switch(option) {
           case 1:
        	   try {
        	   System.out.println("Kindly fill in the following details to create an account");
        	   System.out.println("enter your name");
        	   String name=bufferedreader.readLine();
        	   name=name.trim();
        	   registermodel.setName(name);
        	   System.out.println("Enter a username");
        	   String userName=bufferedreader.readLine();
        	   userName=userName.trim();
        	   registermodel.setUserName(userName);
        	   System.out.println("Enter a password");
        	   String password=bufferedreader.readLine();
        	   password=password.trim();
        	   registermodel.setPassword(password);
        	   System.out.println("Confirm password");
        	   String passwordConfirm=bufferedreader.readLine();
        	   passwordConfirm=passwordConfirm.trim();
        	   registermodel.setPasswordConfirm(passwordConfirm);
        	   System.out.println("enter your profession");
        	   String profession=bufferedreader.readLine();
        	   profession=profession.trim();
        	   registermodel.setProfession(profession);
        	   System.out.println("enter gender");
        	   String gender=bufferedreader.readLine();
        	   gender=gender.trim();
        	   registermodel.setGender(gender);
        	 int flag=registerservice.processRegisterDetails(registermodel);
        	
        	   
        	  switch(flag) {
        	   case 1:
        		   throw new RegisterException("name cannot be empty");
        	   case 2:	   
        		   throw new RegisterException("username cannot be empty"); 
        	   case 3:
        		   throw new RegisterException("length of username is invalid");
        	   case 4:
        		   throw new RegisterException("username cannot start with symbols &$#@");
        	   case 5:
        		   throw new RegisterException("username should't contain spaces");
        	   case 6:
        		   throw new RegisterException("password cannot be blank");
        	   case 7:
        		   throw new RegisterException("password cannot contain space");
        	   case 8:
        		   throw new RegisterException("confirmed password does not match the password");
        	   case 9:
        		   throw new RegisterException("confirmed password cannot be blank");
        	   case 10:
        		   throw new RegisterException("profession cannot be blank");
        	   case 11:
        		   throw new RegisterException("profession cannot be null");
        	   case 12:
        		   throw new RegisterException("gender cannot be empty");
        	   case 13:
        		   throw new RegisterException("user already exist");
        	   case 14:
        		   System.out.println("Registration completed successfully");
        		   break;
        	   case 15:
        		    throw new RegisterException("Registration unsuccessfull");
        	   
        	  }
        	  
        	   }catch(Exception e){
        		    e.printStackTrace();
        		   
        	   }
        	   break;
        	 
        	   
           case 2:
        	   try {
        	   System.out.println("Login page");
        	   System.out.println("Enter username");
        	   String userName=bufferedreader.readLine();
        	   loginmodel.setUserName(userName);
        	   System.out.println("enter password");
        	   String password=bufferedreader.readLine();
        	   loginmodel.setPassword(password);
        	   int flag=loginservice.processLoginDetails(loginmodel);
        	
        	   
        	   switch(flag) {
        	   case 1:
        		   throw new LoginException("username cannot be blank");
        	   
        	   case 2:
        		throw new LoginException("username cannot contain white spaces");
        	   case 3:
        		   throw new LoginException("password cannot be empty");
        	   case 4:
        		   throw new LoginException("password cannot contain space"); 
        	   case 5:
        		   try {
        		   System.out.println("Login sucess");
        		   System.out.println("1.View Item List");
        		   System.out.println("2.Make a purchase");
        		   System.out.println("3.View past transactions");
        		   System.out.println("4.View wallet money");
        		   System.out.println("5.add wallet money");
        		   System.out.println("6.Sign out");
        		   System.out.println("waiting for your selection");
        		   option=Integer.parseInt(bufferedreader.readLine());
        		   switch(option) {
        		   case 1:
        			   itemservice.displayItemDetails(itemmodel);
        		   
        		   case 2:
        			   try {
        			   System.out.println("enter the item");
        			   String item=bufferedreader.readLine();
        			   itemmodel.setItemName(item);
        			   System.out.println("enter quantity");
        			   int quantity=Integer.parseInt(bufferedreader.readLine());
        			   itemmodel.setUserQuantity(quantity);
        			    int flag1=itemservice.checkCart(itemmodel);
        			    if(flag1==0) {
        			    	System.out.println("Out Of Stock");
        			    }else {
        			    	System.out.println("Total cost of the product"+"\t"+flag1);
        			    	System.out.println("do you want to proceed ");
        			    	System.out.println("1.Yes");
        			    	System.out.println("2.No");
        			    	option=Integer.parseInt(bufferedreader.readLine());
        			    	switch(option) {
        			    	case 1:
        			    		System.out.println("you have decided to proceed further");
        			    		int totalMoney=itemservice.purchaseItem(itemmodel);
        			    		System.out.println("You have payed a total of "+totalMoney+"Rs");
        			    		break;
        			    	case 2:
        			    		System.out.println("order cancelled");    
        			    		break;
        			    		
        			    	
        			    		
        			    	}
        			    }
        			    	
        			   }catch(Exception e) {
        				   System.out.println(e.getMessage());
        			   }
        		   
        		   
        		   case 3:
        		   case 4:
        			  
        			   int moneyBalance=registerservice.getWalletCash(registermodel);
        			   System.out.println("Current wallet money"+moneyBalance);
        			   
        			break;
        		   case 5:
        			     registerservice.addWalletMoney(registermodel);   
        		   }
        		   }catch(Exception e) {
        			   System.out.println(e.getMessage());
        		   }
        		  break;
        	   case 6:
        		   throw new LoginException("username or password is incorrect");
        	   }
        	   }catch(Exception e) {
        		   System.out.println(e.getMessage());
        	   }
        	   
        	   
        	   
           
        	   
           }
	
	
	
	
	
	
	
	
	}
    
}
