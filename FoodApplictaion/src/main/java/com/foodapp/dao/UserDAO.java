package com.foodapp.dao;

import java.util.ArrayList;

import com.foodapp.model.User;

public interface UserDAO {
    int addUserTable(User ut);
    ArrayList<User> getAllUsers();
    User getUser(String email);
    int updateUser(User ut);
    int deleteUser(String email);
}
