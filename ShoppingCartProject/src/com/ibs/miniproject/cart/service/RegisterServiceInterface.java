package com.ibs.miniproject.cart.service;

import com.ibs.miniproject.cart.model.RegisterModel;

public interface RegisterServiceInterface {
	int processRegisterDetails(RegisterModel registermodel);
	int getWalletCash(RegisterModel registermodel);
	void addWalletMoney(RegisterModel registermodel);

}
