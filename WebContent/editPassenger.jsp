<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Passenger" %>
<%@ page import="model.PassengerDAO" %>
<%
    // 获取传入的乘客ID
    String passengerID = request.getParameter("passengerID");
    PassengerDAO dao = new PassengerDAO();
    Passenger passenger = dao.getPassengerByID(passengerID); // 获取当前乘客信息

    if (passenger == null) {
        out.println("<script>alert('未找到该乘客信息！'); history.back();</script>");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑乘客</title>
</head>
<body>
    <h2>编辑乘客信息</h2>
    <form action="UpdatePassengerServlet" method="POST">
        <input type="hidden" name="passengerID" value="<%= passenger.getPassengerID() %>">

        <label>姓名:</label>
        <input type="text" name="fullName" value="<%= passenger.getFullName() %>" required><br>

        <label>电话:</label>
        <input type="text" name="phoneNumber" value="<%= passenger.getPhoneNumber() %>" required maxlength="11"><br>

        <label>类型:</label>
        <select name="passengerType">
            <option value="0" <%= passenger.getPassengerType() == 0 ? "selected" : "" %>>儿童</option>
            <option value="1" <%= passenger.getPassengerType() == 1 ? "selected" : "" %>>成人</option>
        </select><br>

        <button type="submit">保存</button>
        <button type="button" onclick="window.location.href='passengerManagement.jsp'">取消</button>
    </form>
</body>
</html>
