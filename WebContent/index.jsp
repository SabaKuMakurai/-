<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
</head>
<body>
    <h2>登录</h2>
    <form action="LoginServlet" method="POST">
        <label>身份证号/电话号码/邮箱:</label>
        <input type="text" name="identifier" required><br>

        <label>密码:</label>
        <input type="password" name="password" required><br>

        <button type="submit">登录</button>
    </form>
    <a href="register.jsp">没有账号？点击注册</a>
    <a href="passwordRecovery.jsp">忘记密码？找回密码</a>
</body>
</html>
