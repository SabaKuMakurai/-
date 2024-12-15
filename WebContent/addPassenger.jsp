<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加乘客</title>
</head>
<body>
    <h2>添加乘客</h2>
    <form action="AddPassengerServlet" method="POST">
        <label>身份证号:</label>
        <input type="text" name="passengerID" required maxlength="18"><br>

        <label>姓名:</label>
        <input type="text" name="fullName" required><br>

        <label>电话:</label>
        <input type="text" name="phoneNumber" required maxlength="11"><br>

        <label>类型:</label>
        <select name="passengerType">
            <option value="" selected disabled>请选择类型</option>
            <option value="0">儿童</option>
            <option value="1">成人</option>
        </select><br>

        <button type="submit">添加</button>
        <button type="button" onclick="window.location.href='passengerManagement.jsp'">取消</button>
    </form>
</body>
</html>
