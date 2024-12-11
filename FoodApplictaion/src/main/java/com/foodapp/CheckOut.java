package com.foodapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CheckOut extends HttpServlet
{ 
	@Override   
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.getWriter().println("Checkout processing...");
		 resp.sendRedirect("checkout.jsp");
	}
	
}
