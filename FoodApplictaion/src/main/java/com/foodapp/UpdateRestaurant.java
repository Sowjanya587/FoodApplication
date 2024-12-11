package com.foodapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.foodapp.daoimpl.RestaurantDAOImpl;
import com.foodapp.model.Restaurant;

public class UpdateRestaurant extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Retrieve the 'id' parameter from the form
            String idParam = req.getParameter("id");

            // Check if 'id' is null or empty
            if (idParam == null || idParam.isEmpty()) {
                throw new IllegalArgumentException("Restaurant ID is missing.");
            }

            // Parse the 'id' to an integer
            int id = Integer.parseInt(idParam);

            // Retrieve the updated restaurant details from the form
            String name = req.getParameter("name");
            String type = req.getParameter("type");
            String address = req.getParameter("address");
            String deliveryTime = req.getParameter("deliverytime");
            String ratings = req.getParameter("ratings");
            String active = req.getParameter("active");

            // Update the restaurant in the database
            RestaurantDAOImpl dao = new RestaurantDAOImpl();
            Restaurant restaurant = new Restaurant(id, name, type, address, Integer.parseInt(deliveryTime), ratings, active);

            dao.updateRestaurant(restaurant); // Assuming updateRestaurant handles database update

            // Redirect to home page after successful update
            resp.sendRedirect("home.jsp");
        } catch (NumberFormatException e) {
            // Handle the case where the ID or any numeric field is invalid
            resp.getWriter().println("Error: Invalid input. Please check the entered values.");
        } catch (IllegalArgumentException e) {
            // Handle the case where the ID is missing
            resp.getWriter().println("Error: Restaurant ID is missing.");
        }
    }
}
