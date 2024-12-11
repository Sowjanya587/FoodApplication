<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.foodapp.model.CartItem" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
    <style>
        body {
            background-image: url('https://img.freepik.com/free-photo/credit-card-payment-concept-with-hand-holding-terminal_23-2148763635.jpg');
            background-size: cover;
            background-attachment: fixed;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            min-height: 100vh;
        }
        h1 {
            color: #ffffff;
            font-size: 2.5em;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.7);
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: rgba(255, 255, 255, 0.9);
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f4b400;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        h3 {
            margin-top: 20px;
            color: #fff;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.7);
        }
        .checkout-section {
            margin-top: 20px;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
        }
        .checkout-section button {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .checkout-section button:hover {
            background-color: #218838;
        }
        .radio-group {
            margin: 20px 0;
        }
        .radio-group label {
            margin-right: 15px;
            font-size: 16px;
            color: #333;
        }
        .action-button {
            background-color: #ff5722;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            padding: 8px 15px;
            font-size: 14px;
        }
        .action-button:hover {
            background-color: #e64a19;
        }
        .back-button {
            display: inline-block;
            margin-top: 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 16px;
            font-weight: bold;
            text-align: center;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }
        .back-button:hover {
            background-color: #0056b3;
            transform: scale(1.05);
        }
    </style>
</head>
<body>

<h1>Your Cart</h1>

<%
    // Retrieve the cart from the session
    ArrayList<CartItem> cart = (ArrayList<CartItem>) session.getAttribute("cart");

    if (cart == null || cart.isEmpty()) {
%>
        <p>Your cart is empty. <a href="menu.jsp" style="color: white; text-decoration: underline;">Continue Shopping</a></p>
<%
    } else {
%>
        <table>
            <tr>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Total</th>
                <th>Actions</th>
            </tr>
            <%
                double totalCartPrice = 0;
                for (CartItem cartItem : cart) {
                    double totalPrice = cartItem.getTotalPrice();
                    totalCartPrice += totalPrice;
            %>
            <tr>
                <td><%= cartItem.getName() %></td>
                <td><%= cartItem.getQuantity() %></td>
                <td>₹<%= cartItem.getPrice() %></td>
                <td>₹<%= totalPrice %></td>
                <td>
                    <form action="DeleteCartItem" method="post" style="display: inline;">
                        <input type="hidden" name="itemId" value="<%= cartItem.getItemid() %>">
                        <button type="submit" class="action-button">Delete</button>
                    </form>
                </td>
            </tr>
            <%
                }
            %>
        </table>

        <h3>Total Cart Price: ₹<%= totalCartPrice %></h3>

        <div class="checkout-section">
            <form action="CheckOut" method="post">
                <div class="radio-group">
                    <label>
                        <input type="radio" name="paymentMethod" value="PhonePe" required> PhonePe
                    </label>
                    <label>
                        <input type="radio" name="paymentMethod" value="Card"> Card
                    </label>
                    <label>
                        <input type="radio" name="paymentMethod" value="Cash"> Cash
                    </label>
                </div>
                <button type="submit">Proceed to Checkout</button>
            </form>
            <form action="ClearCart" method="post">
                <button type="submit" class="action-button" style="margin-top: 15px;">Clear Cart</button>
            </form>
        </div>
<%
    }
%>


<a href="menu.jsp" class="back-button">Back to Menu</a>
</body>
</html>
