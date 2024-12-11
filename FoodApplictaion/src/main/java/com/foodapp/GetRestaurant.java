package com.foodapp;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.daoimpl.RestaurantDAOImpl;
import com.foodapp.model.Restaurant;
    
public class GetRestaurant extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Initialize the DAO implementation
        RestaurantDAOImpl rdao = new RestaurantDAOImpl();
        
        // Attempt to fetch all restaurants
        List<Restaurant> restaurantList = rdao.getAllRestaurants();
        
        if (restaurantList != null && !restaurantList.isEmpty()) {
            for (Restaurant res : restaurantList) {
                System.out.println("Retrieved Restaurant: " + res);
            }
            req.getSession().setAttribute("restaurantList", restaurantList);
            
        } else {
            System.out.println("No restaurants found.");
        }

        resp.sendRedirect("home.jsp");
    }
}
