package model;

import java.sql.*;
import java.util.*;

public class Train {
    private String trainNumber;        // 车次号
    private String departureStation;   // 出发站
    private String arrivalStation;     // 到达站
    private Timestamp departureTime;   // 出发时间
    private Timestamp arrivalTime;     // 到达时间
    private List<TrainStop> trainStops; // 经停站列表

    // 构造方法
    public Train(String trainNumber, String departureStation, String arrivalStation, Timestamp departureTime, Timestamp arrivalTime, List<TrainStop> trainStops) {
        this.trainNumber = trainNumber;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.trainStops = trainStops;
    }

    // Getters and Setters
    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<TrainStop> getTrainStops() {
        return trainStops;
    }

    public void setTrainStops(List<TrainStop> trainStops) {
        this.trainStops = trainStops;
    }
}
