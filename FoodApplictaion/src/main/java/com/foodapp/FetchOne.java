package com.foodapp;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.daoimpl.RestaurantDAOImpl;
import com.foodapp.model.Restaurant;


public class FetchOne extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Fetch restaurant ID from request
            int rid = Integer.parseInt(req.getParameter("rid"));

            // Fetch restaurant details from DAO
            RestaurantDAOImpl rdaoi = new RestaurantDAOImpl();
            Restaurant restaurant = rdaoi.getRestaurantById(rid);

            // Set restaurant in session
            req.getSession().setAttribute("restaurant", restaurant);

            // Redirect to edit page
            resp.sendRedirect("editRestaurant.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error occurred while fetching the restaurant: " + e.getMessage());
        }
    }
}
