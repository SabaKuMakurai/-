<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员主页</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #dc3545;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
        }
        .menu {
            margin: 50px auto;
            text-align: center;
        }
        .menu a {
            display: block;
            margin: 10px auto;
            padding: 10px;
            background-color: #dc3545;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            width: 200px;
            transition: background-color 0.3s;
        }
        .menu a:hover {
            background-color: #bd2130;
        }
    </style>
	<script>
        // 动态更新时间函数
        function updateTime() {
       		var now = new Date();
        	var year = now.getFullYear();
        	var month = String(now.getMonth() + 1).padStart(2, '0');
        	var day = String(now.getDate()).padStart(2, '0');
        	var hours = String(now.getHours()).padStart(2, '0');
        	var minutes = String(now.getMinutes()).padStart(2, '0');
        	var seconds = String(now.getSeconds()).padStart(2, '0');

        	var currentTime = year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
        	document.getElementById("dynamicTime").innerText = currentTime;
    	}

    	window.onload = function () {
        	updateTime();
        	setInterval(updateTime, 1000);
    	};
    </script>
</head>
<body>
    <header>
        <div>欢迎, 管理员 ${sessionScope.fullName}</div>
        <div>
            <form action="LogoutServlet" method="POST">
                <button type="submit" style="background-color: #fff; color: #dc3545; border: none; padding: 5px 10px; cursor: pointer;">退出登录</button>
            </form>
        </div>
    </header>

    <div class="menu">
        <h2>管理员功能</h2>
        <a href="trainManagement.jsp">运营班次管理</a>
        <a href="userManagement.jsp">用户信息管理</a>
        <a href="passengerManagementAdmin.jsp">乘客信息管理</a>
        <a href="orderManagement.jsp">系统订单管理</a>
    </div>
    
    <!-- Footer -->
    <footer>
        当前服务器时间 (UTC+8): <span id="dynamicTime"></span>
    </footer>
</body>
</html>
