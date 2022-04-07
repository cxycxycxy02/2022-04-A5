package com.gatech.cs6310.entites;


import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Line> lines;
    private String orderId;
    private Integer droneId;
    private String customerAccount;

    public Integer getDroneId() {
        return droneId;
    }

    public void setDroneId(Integer droneId) {
        this.droneId = droneId;
    }

    public String getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(String customerAccount) {
        this.customerAccount = customerAccount;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Order(String orderId, String customerAccount, Integer droneId) {
        this.orderId = orderId;
        this.customerAccount = customerAccount;
        this.droneId = droneId;
        this.lines = new ArrayList<>();
    }

    public void addLine(Line line) {
        this.lines.add(line);
    }

    public Integer computePrice() {
        Integer result = 0;
        for (Line line : lines) {
            result += line.computeTotalPrice();
        }
        return result;
    }

    public Integer computeWeight() {
        Integer result = 0;
        for (Line line : lines) {
            result += line.computeTotalWeight();
        }
        return result;
    }

    public void displayOrder() {
        System.out.println("orderID:" + this.getOrderId());
        for (Line line : this.getLines()) {
            line.displayLine();
        }
    }
    public boolean containItem(String itemName){
        for (Line line:this.lines){
            if (line.getItem().getItemName().equals(itemName)){
                return true;
            }
        }
        return false;
    }
}

