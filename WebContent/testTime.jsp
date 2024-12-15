<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>动态时间示例</title>
    <style>
        footer {
            text-align: center;
            background-color: #333;
            color: white;
            padding: 10px 0;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
    <script>
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
    <h1>欢迎来到页面</h1>
    <p>这是一个动态更新时间示例。</p>

    <footer>
        当前时间：<span id="dynamicTime"></span>
    </footer>
</body>
</html>
