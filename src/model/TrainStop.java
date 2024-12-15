package model;

import java.sql.Timestamp;

public class TrainStop {
    private String stationName;    // 站点名称
    private Timestamp arrivalTime; // 到达时间
    private Timestamp departureTime; // 出发时间
    private long travelTime;      // 从出发站到该站点的经过时间（毫秒数）

    // 构造方法
    public TrainStop(String stationName, Timestamp arrivalTime, Timestamp departureTime, long travelTime) {
        this.stationName = stationName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.travelTime = travelTime;
    }

    // Getters and Setters
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public long getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(long travelTime) {
        this.travelTime = travelTime;
    }
}
