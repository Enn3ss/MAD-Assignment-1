package com.example.mad_assignment_1.databases.orders;

public class Order {
    String customerId;
    String time;
    double totalCost;
    String foodList;

    public Order(String customerId, String time, double totalCost, String foodList) {
        this.customerId = customerId;
        this.time = time;
        this.totalCost = totalCost;
        this.foodList = foodList;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getFoodList() {
        return foodList;
    }

    public void setFoodList(String foodList) {
        this.foodList = foodList;
    }
}