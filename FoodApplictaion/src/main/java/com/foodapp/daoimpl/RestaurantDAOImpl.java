package com.foodapp.daoimpl;

import com.foodapp.dao.RestaurantDAO;
import com.foodapp.model.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAOImpl implements RestaurantDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/octjdbc";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Sowji@123";

    // Establishes a database connection
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // Adds a new restaurant to the database   
    @Override
    public int addRestaurant(Restaurant restaurant) {
        String sql = "INSERT INTO restarent (name, type, address, deliverytime, ratings, active) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, restaurant.getName());
            pstmt.setString(2, restaurant.getType());
            pstmt.setString(3, restaurant.getAddress());
            pstmt.setInt(4, restaurant.getDeliverytime());
            pstmt.setString(5, restaurant.getRatings());
            pstmt.setString(6, restaurant.getActive());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Retrieves all restaurants from the database
    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        String sql = "SELECT * FROM restarent";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Restaurant restaurant = new Restaurant(
                    rs.getInt("rid"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getString("address"),
                    rs.getInt("deliverytime"),
                    rs.getString("ratings"),
                    rs.getString("active")
                );
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    // Retrieves a restaurant by its ID
    @Override
    public Restaurant getRestaurantById(int rid) {
        String sql = "SELECT * FROM restarent WHERE rid = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rid);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Restaurant(
                        rs.getInt("rid"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getString("address"),
                        rs.getInt("deliverytime"),
                        rs.getString("ratings"),
                        rs.getString("active")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Updates an existing restaurant in the database
    @Override
    public int updateRestaurant(Restaurant restaurant) {
        String sql = "UPDATE restarent SET name = ?, type = ?, address = ?, deliverytime = ?, ratings = ?, active = ? WHERE rid = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, restaurant.getName());
            pstmt.setString(2, restaurant.getType());
              pstmt.setString(3, restaurant.getAddress());
            pstmt.setInt(4, restaurant.getDeliverytime());
            pstmt.setString(5, restaurant.getRatings());
            pstmt.setString(6, restaurant.getActive());
            pstmt.setInt(7, restaurant.getRid());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Deletes a restaurant by its ID
    @Override
    public int deleteRestaurant(int rid) {
        String sql = "DELETE FROM restarent WHERE rid = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rid);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;    
    }
}
