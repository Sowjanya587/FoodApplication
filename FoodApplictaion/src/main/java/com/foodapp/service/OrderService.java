package com.foodapp.service;

import com.foodapp.dao.OrderDAO;
import com.foodapp.daoimpl.OrderDAOimpl;
import com.foodapp.model.Order;

import javax.servlet.http.HttpSession;
import java.util.List;

public class OrderService {
    private OrderDAO orderDAO;

    public OrderService() {
        this.orderDAO = new OrderDAOimpl(); // Make sure this is properly initialized
    }

    public List<Order> getOrderHistoryForUser(HttpSession session) throws Exception {
        // Check if session exists and contains the logged-in user
        if (session == null || session.getAttribute("loggedInUserId") == null) {
            throw new Exception("User not logged in");
        }

        int userId = (int) session.getAttribute("loggedInUserId");
        return orderDAO.getOrdersByUserId(userId); // Get orders by user ID from DAO
    }
}

