<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thank You</title>
    <style>
        /* General body styling */
        body {
            font-family: 'Roboto', sans-serif;
            background: linear-gradient(135deg, #f7b7a3, #f0d8ff);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            transition: background-color 0.3s ease;
        }

        /* Card styling */
        .card {
            background: #ffffff;
            border-radius: 15px;
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
            padding: 30px;
            text-align: center;
            width: 100%;
            max-width: 400px;
            transform: scale(1);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .card:hover {
            transform: scale(1.05);
            box-shadow: 0 12px 30px rgba(0, 0, 0, 0.2);
        }

        .card h1 {
            color: #4caf50;
            margin: 10px 0;
            font-size: 2.5rem;
            font-weight: bold;
            text-transform: uppercase;
        }

        .card p {
            font-size: 1.1rem;
            color: #555;
            margin: 10px 0;
        }

        /* Rating stars */
        .rating {
            display: flex;
            justify-content: center;
            gap: 10px;
            margin: 20px 0;
        }

        .rating input {
            display: none;
        }

        .rating label {
            font-size: 40px;
            color: #bbb;
            cursor: pointer;
            transition: color 0.3s ease, transform 0.2s ease;
        }

        .rating input:checked ~ label,
        .rating label:hover,
        .rating label:hover ~ label {
            color: #ff9800;
            transform: scale(1.2);
        }

        /* Button styling */
        button {
            background-color: #4caf50;
            color: white;
            border: none;
            padding: 12px 30px;
            border-radius: 50px;
            cursor: pointer;
            font-size: 1.1rem;
            text-transform: uppercase;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        button:hover {
            background-color: #45a049;
            transform: scale(1.05);
        }

        /* Modal styling */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            animation: fadeIn 0.3s ease-in-out;
        }

        .modal-content {
            background-color: #fff;
            margin: 15% auto;
            padding: 30px;
            border-radius: 12px;
            width: 80%;
            max-width: 450px;
            text-align: center;
            animation: slideIn 0.3s ease-out;
        }

        .modal h2 {
            font-size: 1.8rem;
            color: #4caf50;
            margin-bottom: 20px;
        }

        .modal p {
            font-size: 1.2rem;
            color: #333;
            margin-bottom: 20px;
        }

        .modal button {
            background-color: #4caf50;
            color: white;
            border: none;
            padding: 15px 30px;
            border-radius: 50px;
            font-size: 1.1rem;
            text-transform: uppercase;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .modal button:hover {
            background-color: #45a049;
        }

        /* Animations for modal */
        @keyframes fadeIn {
            0% { opacity: 0; }
            100% { opacity: 1; }
        }

        @keyframes slideIn {
            0% { transform: translateY(-40px); opacity: 0; }
            100% { transform: translateY(0); opacity: 1; }
        }

        /* Mobile responsiveness */
        @media (max-width: 480px) {
            .card {
                width: 85%;
            }

            .rating label {
                font-size: 30px;
            }

            .modal-content {
                width: 90%;
            }
        }
    </style>
</head>
<body>
    <div class="card">
        <h1>Thank You!</h1>
        <p>We hope you enjoyed your meal.</p>
        <p>Rate your experience:</p>
        <div class="rating">
            <input type="radio" name="rating" id="star5" value="5">
            <label for="star5">&#9733;</label>
            <input type="radio" name="rating" id="star4" value="4">
            <label for="star4">&#9733;</label>
            <input type="radio" name="rating" id="star3" value="3">
            <label for="star3">&#9733;</label>
            <input type="radio" name="rating" id="star2" value="2">
            <label for="star2">&#9733;</label>
            <input type="radio" name="rating" id="star1" value="1">
            <label for="star1">&#9733;</label>
        </div>
        <button onclick="submitRating()">Submit</button>
    </div>

    <!-- Modal Popup -->
    <div id="ratingModal" class="modal">
        <div class="modal-content">
            <h2>Thank You!</h2>
            <p id="ratingMessage"></p>
            <button onclick="closeModal()">Close</button>
        </div>
    </div>

    <script>
        function submitRating() {
            const rating = document.querySelector('input[name="rating"]:checked');
            const modal = document.getElementById("ratingModal");
            const ratingMessage = document.getElementById("ratingMessage");

            if (rating) {
                ratingMessage.textContent = `You rated us ${rating.value} star(s)!`;
                modal.style.display = "block"; // Show the modal
            } else {
                ratingMessage.textContent = "Please select a rating.";
                modal.style.display = "block"; // Show the modal
            }
        }

        function closeModal() {
            const modal = document.getElementById("ratingModal");
            modal.style.display = "none"; // Close the modal
        }
    </script>
</body>
</html>
