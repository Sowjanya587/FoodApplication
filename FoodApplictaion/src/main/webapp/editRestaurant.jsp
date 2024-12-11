<%@ page import="com.foodapp.model.Restaurant" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Restaurant</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url("https://images.unsplash.com/photo-1498654896293-37aacf113fd9");
            background-size: cover; /* Ensures the image covers the entire page */
            background-repeat: no-repeat; /* Prevents tiling of the image */
            background-attachment: fixed; /* Keeps the image fixed when scrolling */
            background-position: center; /* Centers the image on the page */
            color: #333; /* Sets a default text color */
        }

        h2 {
            text-align: center;
            color: #fff; /* Light color for contrast against the background */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.8); /* Adds a shadow for better readability */
        }

        form {
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent white background */
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Adds subtle depth */
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #555;
        }

        input[type="text"],
        input[type="hidden"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            display: block;
            width: 100%;
            background-color: #007bff;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        p {
            text-align: center;
            color: #fff; /* Matches the page theme */
        }
    </style>
</head>
<body>

    <h2>Update Restaurant Details</h2>

    <form action="UpdateRestaurant" method="post">
        <% 
            // Get the restaurant object from the session
            Restaurant restaurant = (Restaurant) session.getAttribute("restaurant"); 
            if (restaurant != null) {
        %>
        
        <!-- Hidden input for the restaurant ID -->
        <input type="hidden" name="id" value="<%= restaurant.getRid() %>">

        <!-- Form fields for restaurant details -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<%= restaurant.getName() %>">

        <label for="type">Type:</label>
        <input type="text" id="type" name="type" value="<%= restaurant.getType() %>">

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="<%= restaurant.getAddress() %>">

        <label for="deliverytime">Delivery Time:</label>
        <input type="text" id="deliverytime" name="deliverytime" value="<%= restaurant.getDeliverytime() %>">

        <label for="ratings">Ratings:</label>
        <input type="text" id="ratings" name="ratings" value="<%= restaurant.getRatings() %>">

        <label for="active">Active:</label>
        <input type="text" id="active" name="active" value="<%= restaurant.getActive() %>">

        <!-- Submit button -->
        <input type="submit" value="Update Restaurant">
        
        <% 
            } else { 
        %>
        
        <!-- If no restaurant is found in session -->
        <p>No restaurant found in the session.</p>
        
        <% 
            } 
        %>
    </form>

</body>
</html>
