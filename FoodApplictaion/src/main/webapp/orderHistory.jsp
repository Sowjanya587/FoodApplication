<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.model.Order" %> 
<%@ page import="java.util.List" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order History</title>
    
    <!-- Internal CSS -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;

            /* Background image styling */
            background-image: url('https://img.freepik.com/premium-photo/cozy-inviting-restaurant-interior-with-wooden-tableschairsand-warm-lightingcreating-relaxing-welcoming-atmosphere-diningsocializingand-gathering_924727-29325.jpg?w=900');
            background-size: cover; /* Ensures the image covers the entire viewport */
            background-repeat: no-repeat; /* Prevents the image from repeating */
            background-position: center; /* Centers the image */
        }

        h2 {
            text-align: center;
            color: #333;
            margin-top: 20px;
        }

        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9); /* Adds a slight white overlay for better readability */
            border-radius: 10px; /* Rounded corners for a smoother look */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Adds a subtle shadow effect */
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .error-message {
            color: red;
            font-weight: bold;
            text-align: center;
        }

        .no-orders {
            text-align: center;
            font-size: 1.2em;
            color: #555;
        }

        /* Responsive Design */
        @media screen and (max-width: 768px) {
            table {
                width: 100%;
                font-size: 14px;
            }

            th, td {
                padding: 8px;
            }

            h2 {
                font-size: 20px;
            }
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Order History</h2>

    <%-- Display error message if exists --%>
    <% 
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
        <p class="error-message"><%= errorMessage %></p>
    <% 
        }
    %>

    <%-- If there are orders, display them in a table --%>
    <%
        List<Order> orderHistory = (List<Order>) request.getAttribute("orderHistory");
        if (orderHistory != null && !orderHistory.isEmpty()) {
    %>
        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Order Date</th>
                    <th>Status</th>
                    <th>Total Amount</th>
                </tr>
            </thead>
            <tbody>
                <% for (Order order : orderHistory) { %>
                    <tr>
                        <td><%= order.getOrderId() %></td>
                        <td><%= order.getOrderDate() %></td>
                        <td><%= order.getStatus() %></td>
                        <td><%= order.getTotalAmount() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% 
        } else {
    %>
        <p class="no-orders">No orders found.</p>
    <% 
        }
    %>
</div>

</body>
</html>
