package com.foodapp.daoimpl;

import com.foodapp.dao.MenuDAO;
import com.foodapp.model.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDAOImpl implements MenuDAO {
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

    // Adds a new menu item to the database
    @Override
    public int addMenu(Menu menu) {
        String sql = "INSERT INTO menu (rid, name, description, price, ratings) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, menu.getRid());
            pstmt.setString(2, menu.getName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setInt(4, menu.getPrice());
            pstmt.setInt(5, menu.getRatings());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Retrieves all menu items from the database
    @Override
    public List<Menu> getAllMenus() {
        List<Menu> menus = new ArrayList<>();
        String sql = "SELECT * FROM menu";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Menu menu = new Menu(
                    rs.getInt("mid"),
                    rs.getInt("rid"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getInt("price"),
                    rs.getInt("ratings")
                );
                menus.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menus;
    }

    // Retrieves a menu item by its ID
    @Override
    public Menu getMenuById(int mid) {
        String sql = "SELECT * FROM menu WHERE mid = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, mid);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Menu(
                        rs.getInt("mid"),
                        rs.getInt("rid"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("price"),
                        rs.getInt("ratings")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Updates an existing menu item in the database
    @Override
    public int updateMenu(Menu menu) {
        String sql = "UPDATE menu SET rid = ?, name = ?, description = ?, price = ?, ratings = ? WHERE mid = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, menu.getRid());
            pstmt.setString(2, menu.getName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setInt(4, menu.getPrice());
            pstmt.setInt(5, menu.getRatings());
            pstmt.setInt(6, menu.getMid());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Deletes a menu item by its ID
    @Override
    public int deleteMenu(int mid) {
        String sql = "DELETE FROM menu WHERE mid = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, mid);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
