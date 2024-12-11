package com.foodapp;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.daoimpl.MenuDAOImpl;
import com.foodapp.model.Menu;

public class GetMenu extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Initialize the Menu DAO implementation
        MenuDAOImpl mdao = new MenuDAOImpl();
        
        // Attempt to fetch all menu items
        List<Menu> menuList = mdao.getAllMenus();
        
        if (menuList != null && !menuList.isEmpty()) {
            for (Menu menu : menuList) {
                System.out.println("Retrieved Menu: " + menu);
            }
            // Set menu list in the session attribute
            req.getSession().setAttribute("menuList", menuList);
        } else {
            System.out.println("No menu items found.");
        }

        // Redirect to the appropriate JSP page
        resp.sendRedirect("menu.jsp");
    }
}
