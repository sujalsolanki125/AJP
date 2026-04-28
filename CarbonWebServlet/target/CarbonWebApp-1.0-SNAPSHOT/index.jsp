<%-- 
    Document   : index
    Created on : Apr 15, 2026, 11:44:34 PM
    Author     : SUJAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Carbon Footprint Calculator</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f4f7f9; margin: 0; padding: 0;">

    <div style="width: 400px; margin: 50px auto; background: #ffffff; padding: 25px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0,0,0,0.1);">

        <h2 style="text-align: center; color: #2c3e50;">Carbon Footprint Calculator</h2>

        <form action="insert" method="post">

            <label style="font-weight: bold;">Electricity (kWh):</label>
            <input type="text" name="electricity" placeholder="Enter electricity usage"
                style="width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px;">

            <label style="font-weight: bold;">Distance (km):</label>
            <input type="text" name="distance" placeholder="Enter distance traveled"
                style="width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px;">

            <label style="font-weight: bold;">LPG (kg):</label>
            <input type="text" name="lpg" placeholder="Enter LPG usage"
                style="width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px;">

            <label style="font-weight: bold;">Water (litres):</label>
            <input type="text" name="water" placeholder="Enter water consumption"
                style="width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px;">

            <label style="font-weight: bold;">Waste (kg):</label>
            <input type="text" name="waste" placeholder="Enter waste generated"
                style="width: 100%; padding: 8px; margin-top: 5px; margin-bottom: 20px; border: 1px solid #ccc; border-radius: 5px;">

            <button type="submit"
                style="width: 100%; padding: 10px; background-color: #27ae60; color: white; border: none; border-radius: 5px; font-size: 16px; cursor: pointer;">
                Calculate & Save
            </button>

        </form>

        <br>

        <div style="text-align: center;">
            <a href="view" style="text-decoration: none; color: #2980b9; font-weight: bold;">
                View Data
            </a>
        </div>

    </div>

</body>
</html>
