package com.foodapp.dao;

import java.util.List;

import com.foodapp.model.Order;

public interface OrderDAO 
{
	  List<Order> getOrdersByUserId(int userId) throws Exception;

}
