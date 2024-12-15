package servlet;

import model.Order;
import model.OrderDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/SubmitTicketOrderServlet")
public class SubmitTicketOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String seatNumber = request.getParameter("seatNumber");
        String trainNumber = request.getParameter("trainNumber");
        String carriageNumber = request.getParameter("carriageNumber");
        String departureDate = request.getParameter("departureDate");
        String userID = (String) request.getSession().getAttribute("userID");

        // 生成订单并保存到数据库
        OrderDAO orderDAO = new OrderDAO();
        boolean result = orderDAO.createOrder(trainNumber, seatNumber, carriageNumber, departureDate, userID);

        if (result) {
            response.sendRedirect("orderConfirmation.jsp"); // 跳转到订单确认页面
        } else {
            response.getWriter().println("<script>alert('订单提交失败，请稍后再试。'); history.back();</script>");
        }
    }
}