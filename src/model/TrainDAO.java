package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainDAO {
    private Connection connection;

    public TrainDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=SABAKU;encrypt=false;trustServerCertificate=true";
            connection = DriverManager.getConnection(dbURL, "sa", "584520theSK");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 根据日期查询班次信息
    public List<Train> getTrainsByDate(String departureDate) {
        List<Train> trainList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Trains WHERE DepartureDate = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, departureDate);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String trainNumber = rs.getString("TrainNumber");
                String departureStation = rs.getString("DepartureStation");
                String arrivalStation = rs.getString("ArrivalStation");
                Timestamp departureTime = rs.getTimestamp("DepartureTime");
                Timestamp arrivalTime = rs.getTimestamp("ArrivalTime");

                // 查询该车次的所有经停站并计算travelTime
                List<TrainStop> trainStops = getTrainStopsByTrainNumber(trainNumber, departureTime);

                Train train = new Train(trainNumber, departureStation, arrivalStation, departureTime, arrivalTime, trainStops);
                trainList.add(train);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainList;
    }

    // 查询某车次的所有经停站，并计算每个站点的经过时间
    public List<TrainStop> getTrainStopsByTrainNumber(String trainNumber, Timestamp departureTime) {
        List<TrainStop> trainStops = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TrainStops WHERE TrainNumber = ? ORDER BY StopOrder";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, trainNumber);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String stationName = rs.getString("StationName");
                Timestamp arrivalTime = rs.getTimestamp("ArrivalTime");
                Timestamp departureTimeAtStation = rs.getTimestamp("DepartureTime");

                // 计算经过时间
                long travelTime = arrivalTime.getTime() - departureTime.getTime(); // 毫秒数

                TrainStop trainStop = new TrainStop(stationName, arrivalTime, departureTimeAtStation, travelTime);
                trainStops.add(trainStop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainStops;
    }
}
