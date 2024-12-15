<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ page import="java.util.*, java.text.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户主页</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        /* Header */
        header {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        header .username {
            font-size: 18px;
        }

        header .logout {
            display: inline-block;
            padding: 5px 10px;
            background-color: #dc3545;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        header .logout:hover {
            background-color: #c82333;
        }

        /* Content */
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 80vh;
            text-align: center;
        }

        .menu {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 50%;
        }

        .menu h2 {
            color: #007bff;
        }

        .menu a {
            display: block;
            margin: 10px 0;
            padding: 10px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .menu a:hover {
            background-color: #0056b3;
        }

        /* Footer */
        footer {
            text-align: center;
            background-color: #333;
            color: white;
            padding: 10px 0;
            position: fixed;
            bottom: 0;
            width: 100%;
        }

        #dynamicTime {
            font-weight: bold;
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
    <!-- Header -->
    <header>
        <div class="username">
            欢迎, <strong>${sessionScope.fullName}</strong>
        </div>
        <div>
            <form action="LogoutServlet" method="POST" style="display: inline;">
                <button type="submit" class="logout">退出登录</button>
            </form>
        </div>
    </header>

    <!-- Main Content -->
    <div class="container">
        <div class="menu">
            <h2>请选择功能</h2>
            <a href="passengerManagement.jsp">乘客管理</a>
            <a href="trainSchedule.jsp">班次查询</a>
            <a href="ticketBooking.jsp">车票选购</a>
            <a href="orderHistory.jsp">历史订单查询</a>
            <a href="userInfo.jsp">个人信息管理</a>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        当前服务器时间 (UTC+8): <span id="dynamicTime"></span>
    </footer>
</body>
</html>
