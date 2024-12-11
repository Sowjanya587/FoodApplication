package com.foodapp.daoimpl;

import java.sql.*;


import java.util.ArrayList;
import com.foodapp.dao.UserDAO;
import com.foodapp.model.User;

public class UserDAOimpl implements UserDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/octjdbc";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Sowji@123";

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    @Override
    public int addUserTable(User ut) {
        String sql = "INSERT INTO student (uid, name, email, mobileno, password, address) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ut.getUid());
            pstmt.setString(2, ut.getName());
            pstmt.setString(3, ut.getEmail());
            pstmt.setString(4, ut.getMobileno());
            pstmt.setString(5, ut.getPassword());
            pstmt.setString(6, ut.getAddress());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                User user = new User(
                    rs.getInt("uid"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("mobileno"),
                    rs.getString("password"),
                    rs.getString("address")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUser(String email) {
        String sql = "SELECT * FROM student WHERE email = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getInt("uid"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("mobileno"),
                        rs.getString("password"),
                        rs.getString("address")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateUser(User ut) {
        String sql = "UPDATE student SET name = ?, mobileno = ?, password = ?, address = ? WHERE email = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ut.getName());
            pstmt.setString(2, ut.getMobileno());
            pstmt.setString(3, ut.getPassword());
            pstmt.setString(4, ut.getAddress());
            pstmt.setString(5, ut.getEmail());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUser(String email) {
        String sql = "DELETE FROM student WHERE email = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
