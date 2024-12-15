<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <script>
        function validateForm() {
            var userID = document.getElementById("userID").value;
            var phoneNumber = document.getElementById("phoneNumber").value;
            var email = document.getElementById("email").value;
            var password = document.getElementById("password").value;

            var userIDPattern = /^\d{6}\d{8}\d{4}$/; // 身份证格式：18位数字
            var phonePattern = /^1[3-9]\d{9}$/; // 电话号码格式：11位以1开头
            var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // 邮箱格式
            var passwordPattern = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d@$!%*#?&]{8,}$/; // 密码至少8位，含数字和字母

            if (!userIDPattern.test(userID)) {
                alert("身份证号格式错误，请输入18位数字。");
                return false;
            }

            if (!phonePattern.test(phoneNumber)) {
                alert("电话号码格式错误，请输入11位数字。");
                return false;
            }

            if (!emailPattern.test(email)) {
                alert("邮箱格式错误，请重新输入。");
                return false;
            }

            if (!passwordPattern.test(password)) {
                alert("密码格式错误，必须至少8位且包含字母和数字。");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <h2>用户注册</h2>
    <form action="RegisterServlet" method="POST" onsubmit="return validateForm();">
        <label>身份证号:</label>
        <input type="text" id="userID" name="userID" maxlength="18" required><br>

        <label>用户名:</label>
        <input type="text" name="username" required><br>

        <label>密码:</label>
        <input type="password" id="password" name="password" required><br>

        <label>电话号码:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" maxlength="11" required><br>

        <label>邮箱:</label>
        <input type="email" id="email" name="email" required><br>

        <label>真实姓名:</label>
        <input type="text" name="fullName" required><br>

        <label>性别:</label>
        <select name="gender" required>
            <option value="0">女性</option>
            <option value="1">男性</option>
        </select><br>

        <button type="submit">注册</button>
    </form>
</body>
</html>
