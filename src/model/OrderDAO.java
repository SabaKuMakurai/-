package model;

import java.util.*;
import java.sql.*;

public class OrderDAO {
    private Connection connection;

    public OrderDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=SABAKU;encrypt=false;trustServerCertificate=true";
            connection = DriverManager.getConnection(dbURL, "sa", "584520theSK");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 创建订单
    public boolean createOrder(String trainNumber, String seatNumber, String carriageNumber, String departureDate, String userID) {
        try {
            // 生成订单ID
            String orderID = generateOrderID();

            // 获取当前时间
            Timestamp orderDate = new Timestamp(System.currentTimeMillis());

            // 订单状态：假设所有订单默认为未支付
            String status = "未支付";

            String sql = "INSERT INTO Orders (OrderID, UserID, TrainNumber, SeatNumber, CarriageNumber, DepartureDate, OrderDate, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, orderID);
            ps.setString(2, userID);
            ps.setString(3, trainNumber);
            ps.setString(4, seatNumber);
            ps.setString(5, carriageNumber);
            ps.setString(6, departureDate);
            ps.setTimestamp(7, orderDate);
            ps.setString(8, status);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 生成订单ID
    private String generateOrderID() {
        return "ORDER" + System.currentTimeMillis();
    }

    // 根据用户ID和出发日期查询订单
    public List<Order> getOrdersByUserID(String userID) {
        List<Order> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Orders WHERE UserID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order(
                        rs.getString("OrderID"),
                        rs.getString("UserID"),
                        rs.getString("TrainNumber"),
                        rs.getString("SeatNumber"),
                        rs.getString("CarriageNumber"),
                        rs.getString("DepartureDate"),
                        rs.getTimestamp("OrderDate"),
                        rs.getString("Status")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
