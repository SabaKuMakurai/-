package servlet;

import model.Train;
import model.TrainDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

@WebServlet("/SearchTrainServlet")
public class SearchTrainServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departureDate = request.getParameter("departureDate");

        // 使用 TrainDAO 查询班次信息
        TrainDAO trainDAO = new TrainDAO();
        List<Train> trainList = trainDAO.getTrainsByDate(departureDate);

        // 将班次信息传递到 JSP 页面
        request.setAttribute("trainList", trainList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("trainSchedule.jsp");
        dispatcher.forward(request, response);
    }
}