<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.model.CartItem" %>
<%@ page import="java.util.Map" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 20px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    h1 {
        text-align: center;
        color: #333;
    }
    .cart-container {
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
        display: flex;
        flex-direction: column;
        justify-content: space-between;
    }
    .card:hover {
        transform: translateY(-10px);
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
    }
    .card h3 {
        font-size: 1.8em;
        color: #333;
        margin-bottom: 10px;
    }
    .card p {
        margin: 5px 0;
        font-size: 1em;
        color: #555;
    }
    .actions {
        display: flex;
        justify-content: space-between;
        margin-top: 15px;
    }
    .actions form {
        margin: 0;
    }
    .actions button {
        background-color: #007BFF;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 14px;
        transition: background-color 0.3s;
    }
    .actions button:hover {
        background-color: #0056b3;
    }
    .total-container {
        margin-top: 20px;
        font-size: 1.5em;
        color: #333;
        text-align: center;
    }
    .empty-cart {
        text-align: center;
        color: #555;
    }
    a {
        display: inline-block;
        text-align: center;
        margin-top: 20px;
        text-decoration: none;
        color: #007bff;
        font-size: 1.2em;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>

<h1>Your Cart</h1>

<%
    // Retrieve cart items from session
    Map<Integer, CartItem> cartItems = (Map<Integer, CartItem>) session.getAttribute("cartItems");

    if (cartItems != null && !cartItems.isEmpty()) {
        double grandTotal = 0;
%>
    <div class="cart-container">
    <%
        for (CartItem item : cartItems.values()) {
            double total = item.getPrice() * item.getQuantity();
            grandTotal += total;
    %>
        <div class="card">
            <h3><%= item.getName() %></h3>
            <p><strong>Quantity:</strong> <%= item.getQuantity() %></p>
            <p><strong>Price per Item:</strong> ₹<%= item.getPrice() %></p>
            <p><strong>Total:</strong> ₹<%= total %></p>
            <div class="actions">
                <!-- Update quantity -->
                <form action="AddtoCart" method="post">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="itemId" value="<%= item.getItemid() %>">
                    <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1" required>
                    <button type="submit">Update</button>
                </form>
                <!-- Remove item -->
                <form action="AddtoCart" method="post">
                    <input type="hidden" name="action" value="remove">
                    <input type="hidden" name="itemId" value="<%= item.getItemid() %>">
                    <button type="submit">Remove</button>
                </form>
            </div>
        </div>
    <%
        }
    %>
    </div>
    <div class="total-container">
        <strong>Grand Total: ₹<%= grandTotal %></strong>
    </div>
<%
    } else {
%>
    <div class="empty-cart">
        <p>Your cart is empty.</p>
    </div>
<%
    }
%>

<a href="menu.jsp">Continue Shopping</a>
<a href="viewCart.jsp"><button>View Cart</button></a>  

</body>
</html>
