package com.ibs.miniproject.cart.service;

import com.ibs.miniproject.cart.dao.ItemDAO;
import com.ibs.miniproject.cart.dao.ItemDetailsDAO;
import com.ibs.miniproject.cart.dao.ItemPurchaseDAO;
import com.ibs.miniproject.cart.model.ItemModel;

public class ItemService implements ItemServiceInterface{

	@Override
	public int checkCart(ItemModel itemmodel) {
		ItemDAO itemdao=new ItemDAO();
		 int value=itemdao.checkCart(itemmodel);
		return value;
	}

	@Override
	public void displayItemDetails(ItemModel itemmodel) {
		ItemDetailsDAO itemdetailsdao=new ItemDetailsDAO();
		itemdetailsdao.showItemList(itemmodel);
		
		
		
	}

	@Override
	public int  purchaseItem(ItemModel itemmodel) {
		ItemPurchaseDAO itempurchasedao=new ItemPurchaseDAO();
		int value=itempurchasedao.makePurchase(itemmodel);
		return value;
	}
	

}
