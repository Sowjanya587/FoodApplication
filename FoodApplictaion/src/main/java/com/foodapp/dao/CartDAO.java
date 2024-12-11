package com.foodapp.dao;

import java.util.Map;

import com.foodapp.model.CartItem;    

public interface CartDAO 
{
	    Map<Integer, CartItem> addItem(CartItem item);
	    void updateItem(int itemId, int quantity);
	    void removeItem(int itemId);
	    Map<Integer, CartItem> getItems();
	}


