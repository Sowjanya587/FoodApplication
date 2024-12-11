<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.model.Menu" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<style>
    body {
        background-image: url('https://img.freepik.com/free-photo/delicious-food-table_23-2150857814.jpg?ga=GA1.1.1960502642.1731040085&semt=ais_hybrid');
        background-size: cover;
        background-attachment: fixed;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    h1 {
        color: #333;
        font-size: 2.5em;
        margin-bottom: 20px;
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
    }
    .menu-container {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
        gap: 20px;
        width: 90%;
        max-width: 1200px;
    }
    .card {
        background-color: white;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        padding: 20px;
        transition: transform 0.3s, box-shadow 0.3s;
    }
    .card:hover {
        transform: translateY(-10px);
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
    }
    .add-to-cart-form button {
        background-color: #28a745;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    .back-button {
        margin-top: 20px;
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        text-decoration: none;
        display: inline-block;
        text-align: center;
    }
    .back-button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<h1>Our Delicious Menu</h1>

<%
    // Retrieve the menu list from the session
    ArrayList<Menu> menuList = (ArrayList<Menu>) session.getAttribute("menuList");

    if (menuList != null && !menuList.isEmpty()) {
%>
<div class="menu-container">
<%
        for (Menu menu : menuList) {
            if (menu != null) { // Handle null menu objects
%>
    <div class="card">
        <h3><%= menu.getName() %></h3>
        <p><strong>Description:</strong> <%= menu.getDescription() %></p>
        <p><strong>Price:</strong> ₹<%= menu.getPrice() %></p>
        <form class="add-to-cart-form" action="AddtoCart" method="post">
            <input type="hidden" name="mid" value="<%= menu.getMid() %>">
            <label for="quantity-<%= menu.getMid() %>">Quantity:</label>
            <input type="number" id="quantity-<%= menu.getMid() %>" name="quantity" value="1" min="1" required>
            <button type="submit">Add to Cart</button>
        </form>
    </div>
<%
            }
        }
%>
</div>
<%
    } else {
%>
<p>No menu items available for this restaurant.</p>
<%
    }
%>

<!-- Back to Restaurant Button -->
<a href="home.jsp" class="back-button">Back to Restaurant</a>

</body>
</html>
