<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>找回密码</title>
</head>
<body>
    <h2>找回密码</h2>
    <form action="PasswordRecoveryServlet" method="POST">
        <label>身份证号:</label>
        <input type="text" name="userID" required maxlength="18"><br>

        <label>邮箱:</label>
        <input type="email" name="email" required><br>

        <label>真实姓名:</label>
        <input type="text" name="fullName" required><br>

        <label>电话号码:</label>
        <input type="text" name="phoneNumber" required maxlength="11"><br>

        <button type="submit">找回密码</button>
    </form>
</body>
</html>
