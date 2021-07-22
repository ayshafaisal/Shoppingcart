package com.ibs.miniproject.cart.service;

import com.ibs.miniproject.cart.model.ItemModel;

public interface ItemServiceInterface {
	int checkCart(ItemModel itemmodel);
	void displayItemDetails(ItemModel itemmodel);
	int purchaseItem(ItemModel itemmodel);

}
