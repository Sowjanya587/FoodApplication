package com.foodapp.daoimpl;

import com.foodapp.dao.OrderDAO;
import com.foodapp.model.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOimpl implements OrderDAO {
    // Database connection details (you can adjust them based on your DB setup)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/octjdbc";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Sowji@123";

    @Override
    public List<Order> getOrdersByUserId(int userId) throws Exception {
        List<Order> orderList = new ArrayList<>();
        
        // SQL Query to fetch orders for the given user ID
        String sql = "SELECT order_id, user_id, order_date, status, total_amount FROM orders WHERE user_id = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("order_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setStatus(rs.getString("status"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error fetching order history");
        }
        
        return orderList;
    }
}
