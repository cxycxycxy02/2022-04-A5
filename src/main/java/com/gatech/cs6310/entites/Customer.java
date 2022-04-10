package com.gatech.cs6310.entites;

import java.util.Map;
import java.util.TreeMap;

public class Customer extends User{
    private Integer credit;
    private Integer rating;

    private Map<String,Order> orders;

    public Map<String, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, Order> orders) {
        this.orders = orders;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Customer(String account, String firstName, String lastName, String phone, Integer rating, Integer credit){
        this.account  = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.credit = credit;
        this.rating = rating;
        this.orders = new TreeMap<>();
    }

    public void addOrder(String orderId,Order order){
        this.orders.put(orderId,order);
    }

    public void removeOrder(String orderId){
        this.orders.remove(orderId);
    }

    public void displayCustomer(){
        System.out.println("name:" + this.getFirstName() + "_" + this.getLastName() + ",phone:" + this.getPhone() + ",rating:" + this.getRating() +
                ",credit:" + this.getCredit());
    }
    public Integer computeTotalOrderPrice(){
        Integer result = 0;
        for(Order order:orders.values()){
            result += order.computePrice();
        }
        return result;
    }
}
