package model;

import java.sql.*;

public class Order {
    private String orderID;
    private String userID;
    private String trainNumber;
    private String seatNumber;
    private String carriageNumber;
    private String departureDate;
    private Timestamp orderDate;
    private String status;  // 订单状态：已支付/未支付等

    // 构造方法
    public Order(String orderID, String userID, String trainNumber, String seatNumber, String carriageNumber, String departureDate, Timestamp orderDate, String status) {
        this.orderID = orderID;
        this.userID = userID;
        this.trainNumber = trainNumber;
        this.seatNumber = seatNumber;
        this.carriageNumber = carriageNumber;
        this.departureDate = departureDate;
        this.orderDate = orderDate;
        this.status = status;
    }

    // Getters and Setters
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getCarriageNumber() {
        return carriageNumber;
    }

    public void setCarriageNumber(String carriageNumber) {
        this.carriageNumber = carriageNumber;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
