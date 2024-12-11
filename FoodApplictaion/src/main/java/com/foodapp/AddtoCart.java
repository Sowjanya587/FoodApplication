package com.foodapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.daoimpl.CartDAOImpl;
import com.foodapp.daoimpl.MenuDAOImpl;
import com.foodapp.model.CartItem;
import com.foodapp.model.Menu;

public class AddtoCart extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    HttpSession session = req.getSession();
	    
	    @SuppressWarnings("unchecked")
	    List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
	    if (cart == null) {
	        cart = new ArrayList<>();
	    }

	    try {
	        String midParam = req.getParameter("mid");
	        String quantityParam = req.getParameter("quantity");

	        if (midParam == null || quantityParam == null || midParam.isEmpty() || quantityParam.isEmpty()) {
	            throw new IllegalArgumentException("Menu ID or quantity is missing or empty.");
	        }

	        int mid = Integer.parseInt(midParam);
	        int quantity = Integer.parseInt(quantityParam);

	        if (quantity <= 0) {
	            throw new IllegalArgumentException("Quantity must be greater than zero.");
	        }

	        MenuDAOImpl mdaoi = new MenuDAOImpl();
	        Menu menu = mdaoi.getMenuById(mid);
	        if (menu == null) {
	            throw new IllegalArgumentException("Invalid menu ID.");
	        }

	        boolean itemExists = false;
	        for (CartItem cartItem : cart) {
	            if (cartItem.getItemid() == mid) {
	                cartItem.setQuantity(cartItem.getQuantity() + quantity);
	                itemExists = true;
	                break;
	            }
	        }

	        if (!itemExists) {
	            CartItem newCartItem = new CartItem(mid, menu.getRid(), menu.getName(), quantity, menu.getPrice());
	            cart.add(newCartItem);
	        }

	        session.setAttribute("cart", cart);
	        resp.sendRedirect("viewCart.jsp");

	    } catch (Exception e) {
	        req.setAttribute("error", "An error occurred: " + e.getMessage());
	        req.getRequestDispatcher("error.jsp").forward(req, resp);
	    }
	}

}
