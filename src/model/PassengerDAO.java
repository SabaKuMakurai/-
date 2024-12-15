package model;

import java.sql.*;
import java.util.*;

public class PassengerDAO {
    private Connection connection;

    public PassengerDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=毕业设计;encrypt=false;trustServerCertificate=true";
            connection = DriverManager.getConnection(dbURL, "sa", "584520theSK");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取指定用户的乘客列表
    public List<Passenger> getPassengersByUserID(String userID) {
        List<Passenger> passengers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Passengers WHERE UserID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Passenger p = new Passenger(
                        rs.getString("PassengerID"),
                        rs.getString("UserID"),
                        rs.getString("FullName"),
                        rs.getString("PhoneNumber"),
                        rs.getInt("PassengerType")
                );
                passengers.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passengers;
    }

    // 添加乘客
    public boolean addPassenger(Passenger passenger) {
        try {
            String sql = "INSERT INTO Passengers (PassengerID, UserID, FullName, PhoneNumber, PassengerType) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, passenger.getPassengerID());
            ps.setString(2, passenger.getUserID());
            ps.setString(3, passenger.getFullName());
            ps.setString(4, passenger.getPhoneNumber());
            ps.setInt(5, passenger.getPassengerType());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Passenger getPassengerByID(String passengerID) {
        Passenger passenger = null;
        try {
            String sql = "SELECT * FROM Passengers WHERE PassengerID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, passengerID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                passenger = new Passenger(
                    rs.getString("PassengerID"),
                    rs.getString("UserID"),
                    rs.getString("FullName"),
                    rs.getString("PhoneNumber"),
                    rs.getInt("PassengerType")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passenger;
    }

    public boolean updatePassenger(Passenger passenger) {
        try {
            String sql = "UPDATE Passengers SET FullName = ?, PhoneNumber = ?, PassengerType = ? WHERE PassengerID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, passenger.getFullName());
            ps.setString(2, passenger.getPhoneNumber());
            ps.setInt(3, passenger.getPassengerType());
            ps.setString(4, passenger.getPassengerID());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePassenger(String passengerID) {
        try {
            String sql = "DELETE FROM Passengers WHERE PassengerID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, passengerID);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
