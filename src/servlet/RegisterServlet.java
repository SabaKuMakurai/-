package servlet;

import model.User;
import model.UserDAO;
import util.EmailUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8"); // 确保请求内容使用 UTF-8 编码
        PrintWriter out = response.getWriter();

        // 获取用户输入的信息
        String userID = request.getParameter("userID");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        int gender = Integer.parseInt(request.getParameter("gender"));

        // 封装用户对象
        User user = new User();
        user.setUserID(userID);
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        user.setFullName(fullName);
        user.setGender(gender);
        user.setUserType(1); // 默认设置为普通用户

        try {
            // 发送注册确认邮件
            String subject = "注册确认邮件";
            String content = "您好，" + username + "！<br><br>"
                    + "您正在尝试注册金山市域铁路购票网站账号。<br>"
                    + "感谢您的注册！<br>"
                    + "若非您本人操作，请忽略并注意隐私安全。";
            boolean emailSent = EmailUtility.sendEmail(email, subject, content);

            if (emailSent) {
                // 邮件发送成功，执行注册逻辑
                UserDAO dao = new UserDAO();
                if (dao.registerUser(user)) {
                    out.println("<script>alert('注册成功，请登录！');window.location='index.jsp';</script>");
                } else {
                    out.println("<script>alert('注册失败，用户ID或用户名已存在！');history.back();</script>");
                }
            } else {
                // 邮件发送失败
                out.println("<script>alert('注册失败，邮箱无效，无法发送确认邮件！');history.back();</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<script>alert('注册过程中发生错误，请重试！');history.back();</script>");
        }
    }
}
