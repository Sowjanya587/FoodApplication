package com.foodapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.daoimpl.RestaurantDAOImpl;

public class Delete extends HttpServlet {
    @Override    
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ridParam = req.getParameter("rid"); // Get the restaurant ID parameter
        
        if (ridParam != null && !ridParam.isEmpty()) { // Check if the ID is provided and not empty
            try {
                int rid = Integer.parseInt(ridParam); // Convert the restaurant ID to an integer
                
                RestaurantDAOImpl rdaoi = new RestaurantDAOImpl();
                int result = rdaoi.deleteRestaurant(rid); // Delete the restaurant using DAO method
                
                if (result != 0) { // If deletion was successful
                    resp.sendRedirect("delete.jsp"); // Redirect to success page
                } else {
                    resp.sendRedirect("failure.jsp"); // Redirect to failure page if deletion was not successful
                }
            } catch (NumberFormatException e) {
                // Handle invalid ID format (non-numeric values)
                System.out.println("Error: Invalid restaurant ID format.");
                resp.sendRedirect("failure.jsp"); // Redirect to failure page if ID is invalid
            }
        } else {
            // Redirect to failure page if rid is missing or empty
            resp.sendRedirect("failure.jsp"); // Redirect to failure page for invalid input
        }
    }
}
