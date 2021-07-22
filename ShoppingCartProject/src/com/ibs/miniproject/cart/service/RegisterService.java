package com.ibs.miniproject.cart.service;

import com.ibs.miniproject.cart.dao.AddWalletMoney;
import com.ibs.miniproject.cart.dao.RegisterDAO;
import com.ibs.miniproject.cart.dao.ViewWalletMoney;
import com.ibs.miniproject.cart.model.RegisterModel;

public class RegisterService implements RegisterServiceInterface {

	@Override
	public int processRegisterDetails(RegisterModel registermodel) {
		String name=registermodel.getName();
		if(name.isEmpty()||name.equals(null)||name.isBlank())
			return 1;
		 String userName=registermodel.getUserName();
		 if(userName.isBlank()||userName.isEmpty()||userName.equals(null))
			 return 2;
		 else if(userName.length()>16||userName.length()<8)
			 return 3;
		 else if(userName.startsWith("$")||userName.startsWith("#")||userName.startsWith("@")||userName.startsWith("&"))
			 return 4;
		 else  if(userName.contains(" "))
			 return 5;
		 String password=registermodel.getPassword();
		 String confirmPassword=registermodel.getPasswordConfirm();
		 if(password.isBlank()||password.isEmpty())
             return 6;
		 else if(password.contains(" "))
        	  return 7;
          if(!password.equals(confirmPassword))
        	  return 8;
          if(confirmPassword.isBlank()||confirmPassword.isEmpty())
        	  return 9;
          String profession=registermodel.getProfession();
          if(profession.isBlank()||profession.isEmpty())
        	  return 10;
          else if(profession.equals(null))
        	  return 11;
          String gender=registermodel.getGender();
          if(gender.isBlank()||gender.isEmpty())
        	  return 12;
           RegisterDAO registerdao=new RegisterDAO();
           
          int value= registerdao.registerUserDetails(registermodel);
     
		return value;
		
	}

	@Override
	public int getWalletCash(RegisterModel registermodel) {
		ViewWalletMoney viewwalletmoney=new ViewWalletMoney();
		
		int value=viewwalletmoney.getWalletMoney(registermodel);
		return value;
	
		
		
	}

	@Override
	public void addWalletMoney(RegisterModel registermodel) {
		AddWalletMoney addwalletmoney=new AddWalletMoney();
		addwalletmoney.addMoneyToWallet(registermodel);
		
	}

}
