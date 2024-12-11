package com.foodapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.foodapp.daoimpl.UserDAOimpl;
import com.foodapp.model.User;

public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            req.setAttribute("errorMessage", "Email and Password are required");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }

        UserDAOimpl udaoi = new UserDAOimpl();
        User u = udaoi.getUser(email);

        if (u != null) {
            // Assuming password is hashed in the database, replace with actual hashed password comparison
            if (u.getPassword().equals(password)) {
                HttpSession session = req.getSession(true);
                session.setAttribute("loggedInUser", u); // Store the entire user object
                session.setAttribute("loggedInUserId", u.getUid()); // Store userId for further use
                session.setMaxInactiveInterval(30 * 60); // Session timeout (30 minutes)
                resp.sendRedirect("GetRestaurant"); // Redirect to the restaurant page after successful login
            } else {
                req.setAttribute("errorMessage", "Invalid password");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("errorMessage", "No user found with this email");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
