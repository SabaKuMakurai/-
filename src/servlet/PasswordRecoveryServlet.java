package servlet;

import model.UserDAO;
import util.EmailUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/PasswordRecoveryServlet")
public class PasswordRecoveryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String userID = request.getParameter("userID");
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");

        UserDAO dao = new UserDAO();

        // 验证用户信息是否匹配
        if (dao.validateUserForRecovery(userID, email, fullName, phoneNumber)) {
            // 生成新密码：JS + 身份证后6位
            String newPassword = "JS" + userID.substring(userID.length() - 6);

            // 更新用户密码
            boolean isPasswordUpdated = dao.updatePassword(userID, newPassword);

            if (isPasswordUpdated) {
                // 发送邮件通知用户
                String subject = "密码已重置";
                String content = "您的密码已被重置为: " + newPassword + "\n请尽快登录系统并修改密码。";

                boolean isEmailSent = EmailUtility.sendEmail(email, subject, content);

                if (isEmailSent) {
                    out.println("<script>alert('密码已重置，新密码已发送到您的邮箱。');window.location='index.jsp';</script>");
                } else {
                    out.println("<script>alert('邮件发送失败，请稍后重试。');history.back();</script>");
                }
            } else {
                out.println("<script>alert('密码重置失败，请联系管理员。');history.back();</script>");
            }
        } else {
            out.println("<script>alert('验证失败，请检查您的信息是否正确。');history.back();</script>");
        }
    }
}
