package com.gatech.cs6310.entites;





import java.util.Map;
import java.util.TreeMap;

public class Store {
    private Map<String,Item> items;
    private String name;
    private Integer revenue;
    private Map<Integer,Drone> drones;
    private Map<String,Order> orders;

    public Map<String, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, Order> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Map<String,Item> getItems() {
        return items;
    }


    public void setItems(Map<String, Item> items) {
        this.items = items;
    }

    public Map<Integer, Drone> getDrones() {
        return drones;
    }

    public void setDrones(Map<Integer, Drone> drones) {
        this.drones = drones;
    }

    public Store(String name, Integer revenue){
        this.name = name;
        this.revenue = revenue;
        this.items = new TreeMap<>();
        this.drones = new TreeMap<>();
        this.orders = new TreeMap<>();

    }
    public Item findItem(String itemName){
        return items.get(itemName);
        }

    public void addItem(String itemName,Item item){
        this.items.put(itemName,item);
    }

    public void addDrone(Integer DroneID,Drone drone){
        this.drones.put(DroneID,drone);
    }

    public void addOrder(String orderId,Order order){
        this.orders.put(orderId,order);
    }

    public void removeOrder(String orderId){
        this.orders.remove(orderId);
    }

    public void displayStore(){
        System.out.println("name:" + this.getName() + ",revenue:" + this.getRevenue());
    }
}
