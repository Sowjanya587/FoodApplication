package com.foodapp;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.foodapp.model.CartItem;


public class DeleteCartItem extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the session
        HttpSession session = request.getSession();

        // Get the cart from the session
        ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");

        // Get the itemId to be deleted
        String itemId = request.getParameter("itemId");

        if (cart != null && itemId != null) {
            try {
                // Convert itemId to int
                int itemIdInt = Integer.parseInt(itemId);
                // Remove the item with the matching itemId
                cart.removeIf(item -> item.getItemid() == itemIdInt);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Handle invalid itemId gracefully, if needed
            }
        }

        // Redirect back to the cart view
        response.sendRedirect("viewCart.jsp");
    }
}
