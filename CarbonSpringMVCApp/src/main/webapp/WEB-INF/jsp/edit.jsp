<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<title>Edit Record</title>
</head>

<body style="margin:0; padding:0; font-family:Inter, Arial, sans-serif; background:#f8fafc; color:#0f172a;">

<div style="min-height:100vh; display:flex; align-items:center; justify-content:center; padding:30px;">

    <!-- Card -->
    <div style="width:100%; max-width:540px; background:white; border:1px solid #e2e8f0; border-radius:22px; padding:36px; box-shadow:0 20px 40px rgba(15,23,42,0.08);">

        <!-- Header -->
        <div style="margin-bottom:28px;">

            <div style="display:inline-block; background:#dbeafe; color:#1d4ed8; padding:6px 12px; border-radius:999px; font-size:13px; font-weight:700; margin-bottom:14px;">
                Update Entry
            </div>

            <h2 style="margin:0; font-size:32px; font-weight:800; letter-spacing:-1px;">
                Edit Carbon Record
            </h2>

            <p style="margin:10px 0 0 0; color:#64748b; font-size:15px; line-height:1.5;">
                Modify your existing carbon usage details and save the updated values.
            </p>

        </div>

        <!-- Form -->
        <form:form method="post" action="/CarbonSpringMVCApp/update">

            <form:hidden path="id"/>

            <div style="margin-bottom:18px;">
                <label style="display:block; margin-bottom:8px; font-size:14px; font-weight:600;">Electricity</label>
                <form:input path="electricity"
                style="width:100%; padding:13px 14px; border:1px solid #cbd5e1; border-radius:12px; font-size:15px; box-sizing:border-box;"/>
            </div>

            <div style="margin-bottom:18px;">
                <label style="display:block; margin-bottom:8px; font-size:14px; font-weight:600;">Distance</label>
                <form:input path="distance"
                style="width:100%; padding:13px 14px; border:1px solid #cbd5e1; border-radius:12px; font-size:15px; box-sizing:border-box;"/>
            </div>

            <div style="margin-bottom:18px;">
                <label style="display:block; margin-bottom:8px; font-size:14px; font-weight:600;">LPG</label>
                <form:input path="lpg"
                style="width:100%; padding:13px 14px; border:1px solid #cbd5e1; border-radius:12px; font-size:15px; box-sizing:border-box;"/>
            </div>

            <div style="margin-bottom:18px;">
                <label style="display:block; margin-bottom:8px; font-size:14px; font-weight:600;">Water</label>
                <form:input path="water"
                style="width:100%; padding:13px 14px; border:1px solid #cbd5e1; border-radius:12px; font-size:15px; box-sizing:border-box;"/>
            </div>

            <div style="margin-bottom:24px;">
                <label style="display:block; margin-bottom:8px; font-size:14px; font-weight:600;">Waste</label>
                <form:input path="waste"
                style="width:100%; padding:13px 14px; border:1px solid #cbd5e1; border-radius:12px; font-size:15px; box-sizing:border-box;"/>
            </div>

            <input type="submit" value="Update"
            style="width:100%; background:#2563eb; color:white; border:none; padding:14px; border-radius:14px; font-size:15px; font-weight:700; cursor:pointer; box-shadow:0 12px 24px rgba(37,99,235,0.20);">

        </form:form>

        <!-- Footer -->
        <div style="margin-top:22px; text-align:center;">
            <a href="/CarbonSpringMVCApp/view"
            style="text-decoration:none; color:#16a34a; font-weight:600; font-size:14px;">
                ? Back to Records
            </a>
        </div>

    </div>

</div>

</body>
</html>