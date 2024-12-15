package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import model.Passenger;
import model.PassengerDAO;

@WebServlet("/AddPassengerServlet")
public class AddPassengerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String passengerID = request.getParameter("passengerID");
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String passengerTypeStr = request.getParameter("passengerType");

        HttpSession session = request.getSession();
        String userID = (String) session.getAttribute("userID");

        if (passengerTypeStr == null || passengerTypeStr.isEmpty()) {
            response.getWriter().println("<script>alert('请选择乘客类型！');history.back();</script>");
            return;
        }

        int passengerType = Integer.parseInt(passengerTypeStr);

        Passenger passenger = new Passenger(passengerID, userID, fullName, phoneNumber, passengerType);
        PassengerDAO dao = new PassengerDAO();

        boolean result = dao.addPassenger(passenger);
        if (result) {
            response.sendRedirect("passengerManagement.jsp");
        } else {
            response.getWriter().println("<script>alert('添加失败，请检查信息是否重复或错误！'); history.back();</script>");
        }
    }
}
