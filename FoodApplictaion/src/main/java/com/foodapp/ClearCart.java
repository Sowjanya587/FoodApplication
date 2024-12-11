package com.foodapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ClearCart extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the session
        HttpSession session = request.getSession();
        
        // Clear the cart by removing the attribute
        session.removeAttribute("cart");
        
        // Redirect back to the cart view
        response.sendRedirect("viewCart.jsp");
    }
}
