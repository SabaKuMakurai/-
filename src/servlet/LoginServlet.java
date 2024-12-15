package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import model.User;
import model.UserDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String identifier = request.getParameter("identifier");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();
        User user = dao.checkLogin(identifier, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("fullName", user.getFullName());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("userID", user.getUserID());
            session.setAttribute("userType", user.getUserType()); // �洢�û�����

            // �����û�������ת
            if (user.getUserType() == 2) { // ����Ա
                response.sendRedirect("adminHome.jsp");
            } else { // ��ͨ�û�
                response.sendRedirect("home.jsp");
            }
        } else {
            response.getWriter().println("<script>alert('登录失败，请检查用户名或密码！');history.back();</script>");
        }
    }
}
