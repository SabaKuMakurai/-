<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ page import="java.util.*, java.text.*,model.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>车票购买</title>
</head>
<body>
    <h2>车票购买</h2>
    <form action="SubmitTicketOrderServlet" method="POST">
        <label for="carriageNumber">选择车厢号:</label>
        <select name="carriageNumber" id="carriageNumber" required>
            <option value="1">车厢 1 (普通票)</option>
            <option value="2">车厢 2 (普通票)</option>
            <!-- 更多车厢 -->
        </select><br><br>

        <button type="submit">查询座位</button>
    </form>

    <% 
        String trainNumber = request.getParameter("trainNumber");
        String departureDate = request.getParameter("departureDate");
        String carriageNumber = request.getParameter("carriageNumber");

        // 查询该车厢的座位信息
        SeatDAO seatDAO = new SeatDAO();
        List<Seat> availableSeats = seatDAO.getAvailableSeats(trainNumber, carriageNumber, departureDate);

        if (availableSeats != null && !availableSeats.isEmpty()) {
            out.println("<h3>可用座位:</h3>");
            out.println("<table border='1'><tr><th>座位号</th><th>状态</th><th>选择</th></tr>");

            for (Seat seat : availableSeats) {
                out.println("<tr>");
                out.println("<td>" + seat.getSeatNumber() + "</td>");
                out.println("<td>" + (seat.isOccupied() ? "已占用" : "空闲") + "</td>");
                if (!seat.isOccupied()) {
                    out.println("<td><input type='radio' name='seatNumber' value='" + seat.getSeatNumber() + "'></td>");
                } else {
                    out.println("<td>不可选</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<button type='submit'>提交订单</button>");
        } else {
            out.println("<p>没有可用座位。</p>");
        }
    %>
</body>
</html>
