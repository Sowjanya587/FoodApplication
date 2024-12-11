<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .error-container {
            border: 1px solid red;
            background-color: #ffe6e6;
            padding: 15px;
            border-radius: 5px;
            max-width: 600px;
            margin: 20px auto;
        }
        .error-container h1 {
            color: red;
        }
        .error-container p {
            color: black;
        }
        .error-container a {
            color: blue;
            text-decoration: none;
        }
        .error-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>An Error Occurred</h1>
        <p><strong>Error Details:</strong> <%= request.getAttribute("error") %></p>
        <p><a href="Menu.jsp">Go back to Menu</a></p>
    </div>
</body>
</html>
