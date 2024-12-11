<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.model.Restaurant" %>
<%@ page import="com.foodapp.model.Menu" %>
<%@ page import="java.util.ArrayList" %>  <!-- Added the import for ArrayList -->
<%@ page import="java.util.List" %>     <!-- Added the import for List (optional, but best practice) -->
<%@ page import="com.foodapp.model.User" %>  <!-- Added import for User class -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home-page</title>
    <style>
        /* CSS styling here */
        body {
            background-image: url('https://images.unsplash.com/photo-1565299624946-b28f40a0ae38');
            background-size: cover;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .add-button-container {
            width: 100%;
            text-align: center;
            margin-bottom: 20px;
        }
        .add-button-container button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .card {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            margin: 15px;
            padding: 20px;
            width: 300px;
            text-align: left;
            display: flex;
            flex-direction: column;
            align-items: flex-start;
        }
        .card h3 {
            font-size: 1.2em;
            margin: 0 0 10px;
            color: #333;
        }
        .card p {
            margin: 8px 0;
            font-size: 0.9em;
            color: #555;
        }
        .table-header {
            font-weight: bold;
            color: #444;
        }
        .card-buttons {
            display: flex;
            gap: 10px;
            margin-top: 15px;
            flex-wrap: wrap;
        }
        .card-buttons button {
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s ease;
        }
        .card-buttons .edit-btn {
            background-color: #007BFF; /* Blue for Edit button */
            color: white;
        }
        .card-buttons .edit-btn:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }
        .card-buttons .delete-btn {
            background-color: #FF4C4C; /* Red for Delete button */
            color: white;
        }
        .card-buttons .delete-btn:hover {
            background-color: #e03e3e; /* Darker red on hover */
        }
        .card-buttons .view-cart-btn {
            background-color: #FFA500; /* Orange for View Cart button */
            color: white;
            width: 100%; /* Makes the button take up the full width of the card */
            text-align: center;
            margin-top: 10px;
        }
        .card-buttons .view-cart-btn:hover {
            background-color: #e68900; /* Darker orange on hover */
        }
    </style>
</head>
<body>
    <div class="add-button-container">
        <a href="addaRestaurant.jsp"><button>Add a Restaurant</button></a>
    </div>

    <% 
        // Fetching logged-in user from the session
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) {
            // If no user is logged in, redirect to login page
            response.sendRedirect("login.jsp");
            return;
        }

        // Fetching restaurant and menu list from session
        List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("restaurantList");
        List<Menu> menuList = (List<Menu>) session.getAttribute("menuList");

        if (restaurantList != null && !restaurantList.isEmpty()) {
            for (Restaurant res : restaurantList) {
    %>

    <div class="card">
        <h3><%= res.getName() %></h3>
        <p><span class="table-header">Type:</span> <%= res.getType() %></p>
        <p><span class="table-header">Address:</span> <%= res.getAddress() %></p>
        <p><span class="table-header">Delivery Time:</span> <%= res.getDeliverytime() %> mins</p>
        <p><span class="table-header">Ratings:</span> <%= res.getRatings() %></p>
        <p><span class="table-header">Active:</span> <%= res.getActive() %></p>
        
        <!-- Display menus only for the current restaurant -->
        <% 
            if (menuList != null && !menuList.isEmpty()) {
                for (Menu m : menuList) {
                    if (m.getRid() == res.getRid()) {  // Ensure menu belongs to current restaurant
        %>
                    <p><span class="table-header">Menu Item:</span> <%= m.getName() %> - <%= m.getPrice() %> </p>
                    <p><span class="table-header">Description:</span> <%= m.getDescription() %></p>
        <% 
                    }
                }
            }
        %>
        
        <div class="card-buttons">
            <a href="FetchOne?rid=<%= res.getRid() %>"><button class="edit-btn">Edit</button></a>
            <a href="Delete?rid=<%= res.getRid() %>"><button class="delete-btn">Delete</button></a>
            <a href="GetMenu?Menu=<%= res.getRid() %>"><button class="view-cart-btn">View Cart</button></a>
            <!-- Button to navigate to order history page -->
            <a href="OrderHistory?uid=<%= user.getUid() %>"><button class="back-button">Order History</button></a>
        </div>
    </div>

    <% 
            }
        } else {
    %>
        <div class="card">
            <h3>Restaurant Data Not Available</h3>
        </div>
    <% 
        }
    %>

</body>
</html>
