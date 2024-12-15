package model;

import java.sql.*;
import java.util.*;

public class SeatDAO {
    private Connection connection;

    public SeatDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=SABAKU;encrypt=false;trustServerCertificate=true";
            connection = DriverManager.getConnection(dbURL, "sa", "584520theSK");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 查询某个车次和车厢号的座位占用情况
    public List<Seat> getAvailableSeats(String trainNumber, String carriageNumber, String departureDate) {
        List<Seat> seatList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Seats WHERE TrainNumber = ? AND CarriageNumber = ? AND DepartureDate = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, trainNumber);
            ps.setString(2, carriageNumber);
            ps.setString(3, departureDate);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Seat seat = new Seat(
                    rs.getString("SeatNumber"),
                    rs.getBoolean("IsOccupied")
                );
                seatList.add(seat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seatList;
    }
}
