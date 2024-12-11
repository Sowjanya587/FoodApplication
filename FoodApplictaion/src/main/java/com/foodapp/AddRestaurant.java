package com.foodapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.daoimpl.RestaurantDAOImpl;
import com.foodapp.model.Restaurant;


public class AddRestaurant extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Restaurant r=new Restaurant(req.getParameter("name"),
				req.getParameter("type"),
				req.getParameter("address"),
	   			Integer.parseInt(req.getParameter("deliverytime")),
			   	req.getParameter("ratings"),
				req.getParameter("active"));
		RestaurantDAOImpl rdaoi=new RestaurantDAOImpl();
		int status=rdaoi.addRestaurant(r);  
		if(status==1)
		{
			resp.sendRedirect("home.jsp");    
			//success  
		}
		else
		{
			resp.sendRedirect("failur.jsp");
			//failure
		}
	}
	         
}
