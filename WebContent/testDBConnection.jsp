<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>测试数据库连接</title>
</head>
<body>
    <h2>数据库连接测试</h2>
    <%
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=毕业设计;encrypt=false;trustServerCertificate=true";
        String dbUser = "sa";
        String dbPass = "584520theSK";
        Connection conn = null;
        try {
            // 加载 SQL Server JDBC 驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
            out.println("<p style='color:green;'>数据库连接成功！</p>");
        } catch (ClassNotFoundException e) {
            out.println("<p style='color:red;'>JDBC 驱动未找到: " + e.getMessage() + "</p>");
        } catch (SQLException e) {
            out.println("<p style='color:red;'>数据库连接失败: " + e.getMessage() + "</p>");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    out.println("<p>数据库连接已关闭。</p>");
                } catch (SQLException e) {
                    out.println("<p style='color:red;'>关闭连接时发生错误: " + e.getMessage() + "</p>");
                }
            }
        }
    %>
</body>
</html>
