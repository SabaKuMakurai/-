package servlet;

import model.PassengerDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/DeletePassengerServlet")
public class DeletePassengerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passengerID = request.getParameter("passengerID");

        PassengerDAO dao = new PassengerDAO();
        boolean deleted = dao.deletePassenger(passengerID);

        if (deleted) {
            response.sendRedirect("passengerManagement.jsp");
        } else {
            response.getWriter().println("<script>alert('删除失败，请重试！'); history.back();</script>");
        }
    }
}
