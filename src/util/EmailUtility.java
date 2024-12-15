package util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailUtility {
    public static boolean sendEmail(String to, String subject, String content) {
        String host = "smtp.qq.com";
        String from = "1503358065@qq.com";
        final String password = "sxbtquetdkaxfhac"; // QQ邮箱授权码

        // 配置邮件服务器属性
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");

        // 认证
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // 创建邮件
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from, "金山市域铁路购票系统通知", "UTF-8")); // 设置发件人姓名为UTF-8编码
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject, "UTF-8"); // 设置邮件主题编码为UTF-8
            message.setContent(content, "text/html; charset=UTF-8"); // 设置邮件内容编码为UTF-8

            // 发送邮件
            Transport.send(message);
            return true;
        } catch (MessagingException | java.io.UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
