package com.foodapp;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.foodapp.service.OrderService;
import com.foodapp.model.Order;

public class OrderHistory extends HttpServlet {    
    private OrderService orderService;

    public OrderHistory() {
        this.orderService = new OrderService(); // Initialize the service class
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Prevent caching
        resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, private");
        resp.setHeader("Pragma", "no-cache");

        // Retrieve session
        HttpSession session = req.getSession(false); // Do not create a new session

        try {
            // Call the service method to fetch the order history
            List<Order> orderHistory = orderService.getOrderHistoryForUser(session);

            // Add the order list to the request scope
            req.setAttribute("orderHistory", orderHistory);

            // Forward the request to the JSP page
            req.getRequestDispatcher("orderHistory.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(); // Log the error for debugging
            req.setAttribute("errorMessage", "Unable to fetch order history. Please try again later.");
            req.getRequestDispatcher("error.jsp").forward(req, resp); // Forward to an error page
        }
    }
}
