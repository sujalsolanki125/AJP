<html>
<head>
<title>Carbon Calculator</title>
</head>

<body style="margin:0; padding:0; font-family:Inter, Arial, sans-serif; background:#f8fafc; color:#0f172a;">

<div style="min-height:100vh; display:flex; align-items:center; justify-content:center; padding:30px;">

    <!-- Card -->
    <div style="width:100%; max-width:520px; background:white; border:1px solid #e2e8f0; border-radius:22px; padding:36px; box-shadow:0 20px 40px rgba(15,23,42,0.08);">

        <!-- Header -->
        <div style="margin-bottom:28px;">

            <div style="display:inline-block; background:#dcfce7; color:#166534; font-size:13px; font-weight:700; padding:6px 12px; border-radius:999px; margin-bottom:14px;">
                Carbon Tracker
            </div>

            <h2 style="margin:0; font-size:32px; font-weight:800; letter-spacing:-1px;">
                Add Carbon Record
            </h2>

            <p style="margin:10px 0 0 0; color:#64748b; font-size:15px; line-height:1.5;">
                Enter your daily resource usage to calculate and store your carbon footprint.
            </p>

        </div>

        <!-- Form -->
        <form action="save" method="post">

            <div style="margin-bottom:18px;">
                <label style="display:block; margin-bottom:8px; font-size:14px; font-weight:600;">Electricity</label>
                <input type="text" name="electricity"
                style="width:100%; padding:13px 14px; border:1px solid #cbd5e1; border-radius:12px; font-size:15px; outline:none; box-sizing:border-box;">
            </div>

            <div style="margin-bottom:18px;">
                <label style="display:block; margin-bottom:8px; font-size:14px; font-weight:600;">Distance</label>
                <input type="text" name="distance"
                style="width:100%; padding:13px 14px; border:1px solid #cbd5e1; border-radius:12px; font-size:15px; outline:none; box-sizing:border-box;">
            </div>

            <div style="margin-bottom:18px;">
                <label style="display:block; margin-bottom:8px; font-size:14px; font-weight:600;">LPG</label>
                <input type="text" name="lpg"
                style="width:100%; padding:13px 14px; border:1px solid #cbd5e1; border-radius:12px; font-size:15px; outline:none; box-sizing:border-box;">
            </div>

            <div style="margin-bottom:18px;">
                <label style="display:block; margin-bottom:8px; font-size:14px; font-weight:600;">Water</label>
                <input type="text" name="water"
                style="width:100%; padding:13px 14px; border:1px solid #cbd5e1; border-radius:12px; font-size:15px; outline:none; box-sizing:border-box;">
            </div>

            <div style="margin-bottom:24px;">
                <label style="display:block; margin-bottom:8px; font-size:14px; font-weight:600;">Waste</label>
                <input type="text" name="waste"
                style="width:100%; padding:13px 14px; border:1px solid #cbd5e1; border-radius:12px; font-size:15px; outline:none; box-sizing:border-box;">
            </div>

            <input type="submit" value="Save"
            style="width:100%; background:#16a34a; color:white; border:none; padding:14px; border-radius:14px; font-size:15px; font-weight:700; cursor:pointer; box-shadow:0 12px 24px rgba(22,163,74,0.20);">

        </form>

        <!-- Footer -->
        <div style="margin-top:22px; text-align:center;">
            <a href="view"
            style="text-decoration:none; color:#2563eb; font-weight:600; font-size:14px;">
                View Records ?
            </a>
        </div>

    </div>

</div>

</body>
</html>