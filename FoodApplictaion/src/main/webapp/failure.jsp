<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Failed</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .message-container {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 30px;
            text-align: center;
            width: 400px;
        }
        .message-container h2 {
            color: red;
        }
        .message-container p {
            margin-bottom: 20px;
        }
        .message-container a {
            display: inline-block;
            background-color: #FF4C4C;
            color: white;
            padding: 10px 20px;
            border-radius: 4px;
            text-decoration: none;
            font-size: 16px;
        }
        .message-container a:hover {
            background-color: #f44336;
        }
    </style>
</head>
<body>
    <div class="message-container">
        <h2>Failed to Delete Restaurant</h2>
        <p>There was an issue while trying to delete the restaurant. Please try again.</p>
        <a href="home.jsp">Back to Home</a>
    </div>
</body>
</html>
