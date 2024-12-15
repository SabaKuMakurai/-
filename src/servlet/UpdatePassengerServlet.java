package servlet;

import model.Passenger;
import model.PassengerDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/UpdatePassengerServlet")
public class UpdatePassengerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String passengerID = request.getParameter("passengerID");
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        int passengerType = Integer.parseInt(request.getParameter("passengerType"));

        Passenger passenger = new Passenger(passengerID, null, fullName, phoneNumber, passengerType);
        PassengerDAO dao = new PassengerDAO();

        boolean updated = dao.updatePassenger(passenger);

        if (updated) {
            response.sendRedirect("passengerManagement.jsp");
        } else {
            response.getWriter().println("<script>alert('更新失败，请重试！'); history.back();</script>");
        }
    }
}
