<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>View Records</title>
</head>

<body style="margin:0; padding:0; font-family:Inter, Arial, sans-serif; background:#f8fafc; color:#0f172a;">

<div style="max-width:1400px; margin:40px auto; padding:0 24px;">

    <!-- Header -->
    <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:28px; flex-wrap:wrap; gap:16px;">

        <div>
            <h1 style="margin:0; font-size:34px; font-weight:800; letter-spacing:-1px;">
                All Carbon Records
            </h1>

            <p style="margin:8px 0 0 0; color:#64748b; font-size:15px;">
                Monitor and manage your carbon footprint entries
            </p>
        </div>

        <a href="${pageContext.request.contextPath}/"
           style="text-decoration:none; background:#16a34a; color:white; padding:12px 18px; border-radius:12px; font-weight:600; font-size:14px; box-shadow:0 10px 20px rgba(22,163,74,0.18);">
            + Add New Record
        </a>

    </div>

    <!-- Card -->
    <div style="background:white; border:1px solid #e2e8f0; border-radius:18px; overflow:hidden; box-shadow:0 10px 30px rgba(15,23,42,0.06);">

        <!-- Table -->
        <div style="overflow-x:auto;">

            <table style="width:100%; border-collapse:collapse; min-width:1200px;">

                <tr style="background:#f8fafc;">

                    <th style="padding:16px; text-align:left; font-size:13px; color:#475569; border-bottom:1px solid #e2e8f0;">ID</th>

                    <th style="padding:16px; text-align:left; font-size:13px; color:#475569; border-bottom:1px solid #e2e8f0;">Electricity</th>

                    <th style="padding:16px; text-align:left; font-size:13px; color:#475569; border-bottom:1px solid #e2e8f0;">Distance</th>

                    <th style="padding:16px; text-align:left; font-size:13px; color:#475569; border-bottom:1px solid #e2e8f0;">LPG</th>

                    <th style="padding:16px; text-align:left; font-size:13px; color:#475569; border-bottom:1px solid #e2e8f0;">Water</th>

                    <th style="padding:16px; text-align:left; font-size:13px; color:#475569; border-bottom:1px solid #e2e8f0;">Waste</th>

                    <th style="padding:16px; text-align:left; font-size:13px; color:#475569; border-bottom:1px solid #e2e8f0;">Total</th>

                    <th style="padding:16px; text-align:center; font-size:13px; color:#475569; border-bottom:1px solid #e2e8f0;">Edit</th>

                    <th style="padding:16px; text-align:center; font-size:13px; color:#475569; border-bottom:1px solid #e2e8f0;">Delete</th>

                </tr>

                <c:forEach var="u" items="${list}">

                <tr style="transition:0.2s;">

                    <td style="padding:16px; border-bottom:1px solid #f1f5f9; font-weight:600;">
                        ${u.id}
                    </td>

                    <td style="padding:16px; border-bottom:1px solid #f1f5f9;">
                        ${u.electricity}
                    </td>

                    <td style="padding:16px; border-bottom:1px solid #f1f5f9;">
                        ${u.distance}
                    </td>

                    <td style="padding:16px; border-bottom:1px solid #f1f5f9;">
                        ${u.lpg}
                    </td>

                    <td style="padding:16px; border-bottom:1px solid #f1f5f9;">
                        ${u.water}
                    </td>

                    <td style="padding:16px; border-bottom:1px solid #f1f5f9;">
                        ${u.waste}
                    </td>

                    <td style="padding:16px; border-bottom:1px solid #f1f5f9;">
                        <span style="background:#dcfce7; color:#166534; padding:6px 10px; border-radius:999px; font-size:13px; font-weight:700;">
                            ${u.total}
                        </span>
                    </td>

                    <td style="padding:16px; text-align:center; border-bottom:1px solid #f1f5f9;">
                        <a href="edit/${u.id}"
                           style="text-decoration:none; background:#2563eb; color:white; padding:8px 12px; border-radius:8px; font-size:13px; font-weight:600;">
                            Edit
                        </a>
                    </td>

                    <td style="padding:16px; text-align:center; border-bottom:1px solid #f1f5f9;">
                        <a href="delete/${u.id}"
                           onclick="return confirm('Delete this record?')"
                           style="text-decoration:none; background:#dc2626; color:white; padding:8px 12px; border-radius:8px; font-size:13px; font-weight:600;">
                            Delete
                        </a>
                    </td>

                </tr>

                </c:forEach>

            </table>

        </div>

    </div>

    <!-- Footer -->
    <div style="margin-top:18px; color:#94a3b8; font-size:13px;">
        Spring MVC CRUD Dashboard
    </div>

</div>

</body>
</html>