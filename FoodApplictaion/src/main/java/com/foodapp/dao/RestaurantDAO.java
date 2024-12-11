package com.foodapp.dao;

import com.foodapp.model.Restaurant;
import java.util.ArrayList;
import java.util.List;

public interface RestaurantDAO {
    int addRestaurant(Restaurant restaurant);
    List<Restaurant> getAllRestaurants();
    Restaurant getRestaurantById(int rid);
    int updateRestaurant(Restaurant restaurant);
    int deleteRestaurant(int rid);
}

