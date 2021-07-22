package com.ibs.miniproject.cart.service;

import com.ibs.miniproject.cart.dao.LoginDAO;
import com.ibs.miniproject.cart.model.LoginModel;

public class LoginService implements LoginServiceInterface{

	@Override
	public int processLoginDetails(LoginModel loginmodel) {
		String userName=loginmodel.getUserName();
		if(userName.isBlank()||userName.isEmpty())
			return 1;
		else if(userName.contains(" "))
			return 2;
		String password=loginmodel.getPassword();
		if(password.isBlank()||password.isEmpty())
			return 3;
		else if(password.contains(" "))
			return 4;
		
		
		LoginDAO logindao=new LoginDAO();
		int value=logindao.processLoginData(loginmodel);
		
		return value;
		
	}

}
