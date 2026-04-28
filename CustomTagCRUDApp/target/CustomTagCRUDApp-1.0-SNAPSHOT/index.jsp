<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/crud" prefix="db" %>
<!DOCTYPE html>
<html>
<head>
    <title>Carbon CRUD Dashboard</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f4f7f6; margin: 30px; }
        .container { display: flex; gap: 20px; align-items: flex-start; }
        .form-section { background: white; border-radius: 8px; padding: 20px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); flex: 1; }
        h2, h3 { color: #2c3e50; }
        .input-group { margin-bottom: 10px; }
        .input-group label { display: block; font-weight: bold; font-size: 12px; color: #555; }
        input[type="number"], input[type="text"] { width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        button { width: 100%; padding: 10px; background-color: #27ae60; color: white; border: none; border-radius: 4px; font-weight: bold; cursor: pointer; margin-top: 10px; }
        button.delete-btn { background-color: #e74c3c; }
        .table-section { background: white; border-radius: 8px; padding: 20px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); margin-top: 20px; }
    </style>
</head>
<body>
    <h2>🌱 Carbon Footprint Manager (Custom Tags CRUD)</h2>

    <%-- 1. Execute Logic --%>
    <% 
        String act = request.getParameter("action");
        if(act != null && !act.equals("view")) { 
    %>
        <div style="background: #fff; padding: 15px; border-radius: 5px; margin-bottom: 15px;">
            <db:operate action="${param.action}" 
                        uid="${param.uid}" 
                        elec="${param.elec}" dist="${param.dist}" 
                        lpg="${param.lpg}" water="${param.water}" waste="${param.waste}" />
        </div>
    <% } %>

    <%-- 2. Input Forms --%>
    <div class="container">
        <div class="form-section">
            <h3>➕ Add Calculation</h3>
            <form>
                <input type="hidden" name="action" value="add">
                <div class="input-group"><label>Electricity (kWh):</label> <input type="number" step="any" name="elec" required></div>
                <div class="input-group"><label>Distance (km):</label> <input type="number" step="any" name="dist" required></div>
                <div class="input-group"><label>LPG (kg):</label> <input type="number" step="any" name="lpg" required></div>
                <div class="input-group"><label>Water (liters):</label> <input type="number" step="any" name="water" required></div>
                <div class="input-group"><label>Waste (kg):</label> <input type="number" step="any" name="waste" required></div>
                <button type="submit">Calculate & Save</button>
            </form>
        </div>

        <div class="form-section">
            <h3>✏️ Update Record</h3>
            <form>
                <input type="hidden" name="action" value="update">
                <div class="input-group"><label>Record ID to Update:</label> <input type="number" name="uid" required></div>
                <div class="input-group"><label>New Electricity:</label> <input type="number" step="any" name="elec" required></div>
                <div class="input-group"><label>New Distance:</label> <input type="number" step="any" name="dist" required></div>
                <div class="input-group"><label>New LPG:</label> <input type="number" step="any" name="lpg" required></div>
                <div class="input-group"><label>New Water:</label> <input type="number" step="any" name="water" required></div>
                <div class="input-group"><label>New Waste:</label> <input type="number" step="any" name="waste" required></div>
                <button type="submit" style="background-color: #2980b9;">Update Values</button>
            </form>
        </div>

        <div class="form-section">
            <h3>🗑️ Delete Record</h3>
            <form>
                <input type="hidden" name="action" value="delete">
                <div class="input-group"><label>Record ID to Delete:</label> <input type="number" name="uid" required></div>
                <button type="submit" class="delete-btn">Permanently Delete</button>
            </form>
        </div>
    </div>

    <%-- 3. Data Table --%>
    <div class="table-section">
        <h3>📊 Database Records</h3>
        <db:operate action="view" />
    </div>

</body>
</html>