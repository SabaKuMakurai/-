package model;

import java.sql.*;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=毕业设计;encrypt=false;trustServerCertificate=true";
            String dbUser = "sa";
            String dbPass = "584520theSK";
            connection = DriverManager.getConnection(dbURL, dbUser, dbPass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean registerUser(User user) {
        try {
            String checkSQL = "SELECT * FROM Users WHERE Username = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkSQL);
            checkStmt.setString(1, user.getUsername());
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next()) {
                return false;  // �û����Ѵ���
            }

            String insertSQL = "INSERT INTO Users (UserID, Username, Password, PhoneNumber, Email, FullName, UserType, Gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertSQL);
            insertStmt.setString(1, user.getUserID());
            insertStmt.setString(2, user.getUsername());
            insertStmt.setString(3, user.getPassword());
            insertStmt.setString(4, user.getPhoneNumber());
            insertStmt.setString(5, user.getEmail());
            insertStmt.setString(6, user.getFullName());
            insertStmt.setInt(7, user.getUserType());
            insertStmt.setInt(8, user.getGender());

            return insertStmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User checkLogin(String identifier, String password) {
        try {
            String sql = "SELECT * FROM Users WHERE (UserID = ? OR PhoneNumber = ? OR Email = ?) AND Password = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, identifier);
            stmt.setString(2, identifier);
            stmt.setString(3, identifier);
            stmt.setString(4, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserID(rs.getString("UserID"));
                user.setUsername(rs.getString("Username"));
                user.setFullName(rs.getString("FullName"));
                user.setUserType(rs.getInt("UserType"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean validateUserForRecovery(String userID, String email, String fullName, String phoneNumber) {
        try {
            String sql = "SELECT * FROM Users WHERE UserID = ? AND Email = ? AND FullName = ? AND PhoneNumber = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, email);
            ps.setString(3, fullName);
            ps.setString(4, phoneNumber);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePassword(String userID, String newPassword) {
        try {
            String sql = "UPDATE Users SET Password = ? WHERE UserID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, userID);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
