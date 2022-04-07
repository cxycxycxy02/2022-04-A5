package com.gatech.cs6310.entites;




import java.util.Map;
import java.util.TreeMap;

public class Drone {
    private String store;
    private Integer droneId;
    private Integer capacity;
    private Integer leftTrip;
    private Map<String, Order> orders;
    private Pilot assignPilot;

    public Pilot getAssignPilot() {
        return assignPilot;
    }

    public void setAssignPilot(Pilot assignPilot) {
        this.assignPilot = assignPilot;
    }

    public Map<String, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, Order> orders) {
        this.orders = orders;
    }

    public Integer getLeftTrip() {
        return leftTrip;
    }

    public void setLeftTrip(Integer leftTrip) {
        this.leftTrip = leftTrip;
    }


    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Integer getDroneId() {
        return droneId;
    }

    public void setDroneId(Integer droneId) {
        this.droneId = droneId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Drone(String store, Integer droneId, Integer capacity, Integer leftTrip) {
        this.store = store;
        this.droneId = droneId;
        this.capacity = capacity;
        this.leftTrip = leftTrip;
        this.orders = new TreeMap<>();
    }

    public Integer computeRemainingCap() {
        int totalCapacity = this.capacity;
        for (Order order : orders.values()) {
            totalCapacity -= order.computeWeight();
        }
        return totalCapacity;
    }

    public void addOrder(String orderId, Order order) {
        this.orders.put(orderId, order);
    }

    public void removeOrder(String orderId) {
        this.orders.remove(orderId);
    }

    public void deliverOrder(String orderId) {
        this.leftTrip -= 1;
        this.assignPilot.setExperience(this.assignPilot.getExperience() + 1);

    }

    public void displayDrone() {
        if (this.getAssignPilot() != null) {
            System.out.println("droneID:" + this.getDroneId() + ",total_cap:" + this.getCapacity()
                    + ",num_orders:" + this.getOrders().size() + ",remaining_cap:" + this.computeRemainingCap()
                    + ",trips_left:" + this.getLeftTrip() + ",flown_by:" + this.getAssignPilot().getFirstName() + "_" + this.getAssignPilot().getLastName());
        } else {
            System.out.println("droneID:" + this.getDroneId() + ",total_cap:" + this.getCapacity()
                    + ",num_orders:" + this.getOrders().size() + ",remaining_cap:" + this.computeRemainingCap()
                    + ",trips_left:" + this.getLeftTrip()

            );
        }
    }


}
