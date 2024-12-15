<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ page import="model.Train, model.TrainStop,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>班次查询</title>
</head>
<body>
    <h2>班次查询</h2>
    <form action="SearchTrainServlet" method="GET">
        <label for="departureDate">选择出发日期:</label>
        <input type="date" id="departureDate" name="departureDate" required><br><br>
        <button type="submit">查询班次</button>
    </form>

    <% 
        // 获取从后台传来的班次信息
        List<Train> trainList = (List<Train>) request.getAttribute("trainList");

        if (trainList != null && !trainList.isEmpty()) {
            out.println("<h3>查询结果:</h3>");
            out.println("<table border='1'><tr><th>车次</th><th>出发站</th><th>到达站</th><th>出发时间</th><th>到达时间</th><th>经停站</th><th>选择</th></tr>");

            for (Train train : trainList) {
                out.println("<tr>");
                out.println("<td>" + train.getTrainNumber() + "</td>");
                out.println("<td>" + train.getDepartureStation() + "</td>");
                out.println("<td>" + train.getArrivalStation() + "</td>");
                out.println("<td>" + train.getDepartureTime() + "</td>");
                out.println("<td>" + train.getArrivalTime() + "</td>");
                
                // 显示每个班次的经停站及其经过时间
                out.println("<td>");
                List<TrainStop> trainStops = train.getTrainStops();
                for (TrainStop stop : trainStops) {
                    out.println(stop.getStationName() + " (到达: " + stop.getArrivalTime() + ", 出发: " + stop.getDepartureTime() + ", 经过时间: " + stop.getTravelTime() / 60000 + " 分钟)<br>");
                }
                out.println("</td>");

                // 添加选择班次的链接
                out.println("<td><a href='ticketBooking.jsp?trainNumber=" + train.getTrainNumber() + "'>选择</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } else {
            out.println("<p>没有找到相关班次。</p>");
        }
    %>
</body>
</html>
