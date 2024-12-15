<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Passenger, model.PassengerDAO" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>乘客管理</title>
    <style>
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        .action-btn {
            padding: 5px 10px;
            margin: 2px;
            text-decoration: none;
            color: white;
            border-radius: 5px;
        }
        .add-btn { background-color: green; }
        .edit-btn { background-color: orange; }
        .delete-btn { background-color: red; }
        footer {
            position: absolute;
            bottom: 0; /* 4. 设置页脚position为absolute之后，再将其bottom值设为0，即可使其处于页面的底部 */
            width: 100%;
        }
    </style>
</head>
<body style="margin:0;padding:0;">
    <h2>乘客管理</h2>

    <%
        // 获取当前用户ID
        String userID = (String) session.getAttribute("userID");

        PassengerDAO passengerDAO = new PassengerDAO();
        List<Passenger> passengers = passengerDAO.getPassengersByUserID(userID);
    %>

    <table>
        <tr>
            <th>身份证号</th>
            <th>姓名</th>
            <th>电话</th>
            <th>类型</th>
            <th>操作</th>
        </tr>
        <% for (Passenger p : passengers) { %>
        <tr>
            <td><%= p.getPassengerID() %></td>
            <td><%= p.getFullName() %></td>
            <td><%= p.getPhoneNumber() %></td>
            <td><%= p.getPassengerType() == 0 ? "儿童" : "成人" %></td>
            <td>
                <a href="editPassenger.jsp?passengerID=<%= p.getPassengerID() %>" class="action-btn edit-btn">修改</a>
                <a href="DeletePassengerServlet?passengerID=<%= p.getPassengerID() %>" class="action-btn delete-btn">删除</a>
            </td>
        </tr>
        <% } %>
    </table>

    <div style="text-align: center;">
        <a href="addPassenger.jsp" class="action-btn add-btn">添加乘客</a>
    </div>
    <!-- Footer -->
    <footer>
	<jsp:include page="returnToHome.jsp" />
    </footer>
</body>
</html>
