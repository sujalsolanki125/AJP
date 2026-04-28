<%@ page contentType="text/html" %>
<!DOCTYPE html>
<html>
<head>
<title>Carbon Calculator</title>
</head>

<body style="margin:0; padding:0; font-family:Arial, sans-serif; background:linear-gradient(to right, #dff6e3, #f4fff6);">

<div style="width:420px; margin:60px auto; background:#ffffff; padding:30px; border-radius:15px; box-shadow:0 8px 20px rgba(0,0,0,0.15);">

    <h2 style="text-align:center; color:#2e7d32; margin-bottom:25px;">
        Carbon Footprint Calculator
    </h2>

    <form action="save.jsp" method="post">

        <label style="font-weight:bold; color:#333;">Electricity</label><br>
        <input type="text" name="electricity"
        style="width:100%; padding:10px; margin-top:5px; margin-bottom:15px; border:1px solid #ccc; border-radius:8px;"><br>

        <label style="font-weight:bold; color:#333;">Distance</label><br>
        <input type="text" name="distance"
        style="width:100%; padding:10px; margin-top:5px; margin-bottom:15px; border:1px solid #ccc; border-radius:8px;"><br>

        <label style="font-weight:bold; color:#333;">LPG</label><br>
        <input type="text" name="lpg"
        style="width:100%; padding:10px; margin-top:5px; margin-bottom:15px; border:1px solid #ccc; border-radius:8px;"><br>

        <label style="font-weight:bold; color:#333;">Water</label><br>
        <input type="text" name="water"
        style="width:100%; padding:10px; margin-top:5px; margin-bottom:15px; border:1px solid #ccc; border-radius:8px;"><br>

        <label style="font-weight:bold; color:#333;">Waste</label><br>
        <input type="text" name="waste"
        style="width:100%; padding:10px; margin-top:5px; margin-bottom:20px; border:1px solid #ccc; border-radius:8px;"><br>

        <button type="submit"
        style="width:100%; padding:12px; background:#43a047; color:white; border:none; border-radius:8px; font-size:16px; cursor:pointer;">
            Save
        </button>

    </form>

    <div style="text-align:center; margin-top:20px;">
        <a href="view.jsp"
        style="text-decoration:none; color:#1b5e20; font-weight:bold;">
            View Data
        </a>
    </div>

</div>

</body>
</html>