<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.model.Restaurant" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Restaurant</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background: url("https://img.freepik.com/premium-photo/cozy-restaurant-interior-with-wooden-tables-chairs-plants-warm-lighting_14117-713862.jpg?w=1060");
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center;
    background-attachment: fixed;
  }
  form {
    background-color: rgba(255, 255, 255, 0.8);
    padding: 20px;
    max-width: 400px;
    margin: auto;
    border-radius: 8px;
  }
  input[type="text"] {
    width: 100%;
    padding: 8px;
    margin: 8px 0;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    width: 100%;
  }
  input[type="submit"]:hover {
    background-color: #45a049;
  }
</style>
</head>
<body>

<form action="AddRestaurant" method="POST">
<%  
    // Get the restaurant object from the session
    Restaurant restaurant = (Restaurant) session.getAttribute("restaurant"); 

    // If the restaurant exists (edit mode), populate the form fields
    if (restaurant != null) {
%>
    <label>Name:</label>
    <input type="text" name="name" value="<%= restaurant.getName() %>"><br>

    <label>Type:</label>
    <input type="text" name="type" value="<%= restaurant.getType() %>"><br>

    <label>Address:</label>
    <input type="text" name="address" value="<%= restaurant.getAddress() %>"><br>

    <label>Delivery Time:</label>
    <input type="text" name="deliverytime" value="<%= restaurant.getDeliverytime() %>"><br>

    <label>Ratings:</label>
    <input type="text" name="ratings" value="<%= restaurant.getRatings() %>"><br>

    <label>Active:</label>
    <input type="text" name="active" value="<%= restaurant.getActive() %>"><br>
<% 
    // If no restaurant is found (add new restaurant mode), just show blank fields
    } else {
%>
    <label>Name:</label>
    <input type="text" name="name" placeholder="Enter restaurant name"><br>

    <label>Type:</label>
    <input type="text" name="type" placeholder="Enter restaurant type"><br>

    <label>Address:</label>
    <input type="text" name="address" placeholder="Enter restaurant address"><br>

    <label>Delivery Time:</label>
    <input type="text" name="deliverytime" placeholder="Enter delivery time"><br>

    <label>Ratings:</label>
    <input type="text" name="ratings" placeholder="Enter ratings"><br>

    <label>Active:</label>
    <input type="text" name="active" placeholder="Enter if restaurant is active"><br>
<% } %>

    <input type="submit" value="Submit">
</form>

</body>
</html>
