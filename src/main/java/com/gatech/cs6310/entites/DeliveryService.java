package com.gatech.cs6310.entites;


import java.util.*;

public class DeliveryService {

    public void commandLoop() {
        Scanner commandLineInput = new Scanner(System.in);
        String wholeInputLine;
        String[] tokens;
        Map<String,Store> stores = new TreeMap<>();
        Map<String,Pilot> pilots = new TreeMap<>();
        Map<String,Customer> customers = new TreeMap<>();
        List<String> licenses = new ArrayList<>();
        final String DELIMITER = ",";

        while (true) {
            try {
                // Determine the next command and echo it to the monitor for testing purposes
                wholeInputLine = commandLineInput.nextLine();
                tokens = wholeInputLine.split(DELIMITER);
                System.out.println("> " + wholeInputLine);
                if (tokens[0].equals("make_store")) {
                    if (stores.containsKey(tokens[1])) {
                        System.out.println("ERROR:store_identifier_already_exists");
                    } else {
                        Store store = new Store(tokens[1], Integer.valueOf(tokens[2]));
                        stores.put(store.getName(), store);
                        System.out.println("OK:change_completed");
                    }

                } else if (tokens[0].equals("display_stores")) {
                    if (!stores.isEmpty()) {
                        for (Store store : stores.values()) {
                            store.displayStore();
                        }
                    }
                    System.out.println("OK:display_completed");
                } else if (tokens[0].equals("sell_item")) {
                    if (!stores.isEmpty() && stores.containsKey(tokens[1])) {
                        Store store = stores.get(tokens[1]);
                        if (store.getItems().containsKey(tokens[2])) {
                            System.out.println("ERROR:item_identifier_already_exists");
                        } else {
                            Item item = new Item(tokens[1], tokens[2], Integer.valueOf(tokens[3]));
                            store.addItem(item.getItemName(), item);
                            System.out.println("OK:change_completed");
                        }

                    }else{
                        System.out.println("ERROR:store_identifier_does_not_exist");
                    }


                } else if (tokens[0].equals("display_items")) {
                    if ( stores.containsKey(tokens[1])) {
                        Store store = stores.get(tokens[1]);
                        for (Item item : store.getItems().values()) {
                            item.displayItem();
                        }
                        System.out.println("OK:display_completed");
                    }else {
                        System.out.println("ERROR:store_identifier_does_not_exist");
                    }

                } else if (tokens[0].equals("make_pilot")) {
                    if (!pilots.containsKey(tokens[1])) {
                        if(!licenses.contains(tokens[6])){
                            Pilot pilot = new Pilot(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], Integer.valueOf(tokens[7]));
                        pilots.put(pilot.account, pilot);
                        licenses.add(tokens[6]);
                        System.out.println("OK:change_completed");
                        }else{
                            System.out.println("ERROR:pilot_license_already_exists");
                        }
                    } else {
                        System.out.println("ERROR:pilot_identifier_already_exists");
                    }


                } else if (tokens[0].equals("display_pilots")) {
                    if (!pilots.isEmpty()) {
                        for (Pilot pilot : pilots.values()) {
                            pilot.displayPilot();
                        }
                        System.out.println("OK:display_completed");

                    } else {
                        System.out.println("ERROR:pilot_identifier_does_not_exist");
                    }

                } else if (tokens[0].equals("make_drone")) {
                    if (stores.containsKey(tokens[1])) {
                        Store store = stores.get(tokens[1]);
                        if (store.getDrones() != null && !store.getDrones().containsKey(Integer.valueOf(tokens[2]))) {
                            Drone drone = new Drone(tokens[1], Integer.valueOf(tokens[2]), Integer.valueOf(tokens[3]), Integer.valueOf(tokens[4]));
                            store.addDrone(Integer.valueOf(tokens[2]), drone);
                            System.out.println("OK:change_completed");
                        } else {
                            System.out.println("ERROR:drone_identifier_already_exists");
                        }
                    } else {
                        System.out.println("ERROR:store_identifier_does_not_exist");
                    }


                } else if (tokens[0].equals("display_drones")) {
                    if (stores.containsKey(tokens[1])) {
                        Store store = stores.get(tokens[1]);
                        for (Drone drone : store.getDrones().values()) {
                            drone.displayDrone();
                        }
                        System.out.println("OK:display_completed");
                    } else {
                        System.out.println("ERROR:store_identifier_does_not_exist");
                    }


                } else if (tokens[0].equals("fly_drone")) {
                    if (stores.containsKey(tokens[1])) {
                        Store store = stores.get(tokens[1]);
                        if (store.getDrones().containsKey(Integer.valueOf(tokens[2]))){
                            Drone drone = store.getDrones().get(Integer.valueOf(tokens[2]));
                            if (pilots.containsKey(tokens[3])){
                                Pilot pilot = pilots.get(tokens[3]);
                                if (drone.getAssignPilot() == null) {
                                    if (pilot.getAssignDrone() != null) {
                                        pilot.getAssignDrone().setAssignPilot(null);
                                    }
                                    pilot.setAssignDrone(drone);
                                    drone.setAssignPilot(pilot);
                                }else {
                                    if (pilot.getAssignDrone() == null) {
                                        drone.getAssignPilot().setAssignDrone(null);
                                        drone.setAssignPilot(pilot);
                                        pilot.setAssignDrone(drone);
                                    } else {
                                        drone.getAssignPilot().setAssignDrone(null);
                                        pilot.getAssignDrone().setAssignPilot(null);
                                        drone.setAssignPilot(pilot);
                                        pilot.setAssignDrone(drone);
                                    }
                                }
                                System.out.println("OK:change_completed");
                            }else {
                                System.out.println("ERROR:pilot_identifier_does_not_exist");
                            }
                        } else{
                            System.out.println("ERROR:drone_identifier_does_not_exist");
                        }
                    } else {
                        System.out.println("ERROR:store_identifier_does_not_exist");
                    }

                } else if (tokens[0].equals("make_customer")) {
                    if (!customers.containsKey(tokens[1])) {
                        Customer customer = new Customer(tokens[1], tokens[2], tokens[3], tokens[4], Integer.valueOf(tokens[5]), Integer.valueOf(tokens[6]));
                        customers.put(customer.getAccount(), customer);
                        System.out.println("OK:change_completed");
                    } else {
                        System.out.println("ERROR:customer_identifier_already_exists");
                    }


                } else if (tokens[0].equals("display_customers")) {
                    if (!customers.isEmpty()) {
                        for (Customer customer : customers.values()) {
                                customer.displayCustomer();
                        }
                        System.out.println("OK:display_completed");

                    } else {
                        System.out.println("ERROR:customer_identifier_does_not_exist");
                    }


                } else if (tokens[0].equals("start_order")) {
                    String storeName = tokens[1];
                    String orderID = tokens[2];
                    int droneID = Integer.parseInt(tokens[3]);
                    String customerAccount = tokens[4];
                    if (stores.containsKey(storeName)) {
                        Store store = stores.get(storeName);
                        Map<String, Order> orders = store.getOrders();
                        if (!orders.containsKey(orderID)) {
                            if (store.getDrones().containsKey(droneID)) {
                                if (customers.containsKey(customerAccount)) {
                                    Customer customer = customers.get(customerAccount);
                                    Order order = new Order(tokens[2], tokens[4], Integer.valueOf(tokens[3]));
                                    store.addOrder(orderID, order);
                                    store.getDrones().get(Integer.valueOf(tokens[3])).addOrder(orderID, order);
                                    customer.addOrder(orderID, order);
                                    System.out.println("OK:change_completed");
                                } else {
                                    System.out.println("ERROR:customer_identifier_does_not_exist");
                                }
                            } else {
                                System.out.println("ERROR:drone_identifier_does_not_exist");
                            }
                        } else {
                            System.out.println("ERROR:order_identifier_already_exists");
                        }
                    } else {
                        System.out.println("ERROR:store_identifier_does_not_exist");
                    }

                } else if (tokens[0].equals("display_orders")) {
                    if (stores.containsKey(tokens[1])) {
                        Store store = stores.get(tokens[1]);
                        for (Order order : store.getOrders().values()) {
                                order.displayOrder();
                            }

                        System.out.println("OK:display_completed");
                    } else {
                        System.out.println("ERROR:store_identifier_does_not_exist");
                    }


                } else if (tokens[0].equals("request_item")) {
                    if(stores.containsKey(tokens[1])){
                        Store store = stores.get(tokens[1]);
                        if ((store.getOrders().containsKey(tokens[2]))){
                            Order order = store.getOrders().get(tokens[2]);
                        if (store.getItems().containsKey(tokens[3])){
                            Item currentItem = store.getItems().get(tokens[3]);
                            if (!order.containItem(currentItem.getItemName())) {
                                Line line = new Line(currentItem, Integer.valueOf(tokens[5]), Integer.valueOf(tokens[4]));
                                Customer customer = customers.get(order.getCustomerAccount());
                                if (customer.getCredit() - customer.computeTotalOrderPrice() >= line.computeTotalPrice()) {
                                    Drone drone = store.getDrones().get(order.getDroneId());
                                    if (drone.computeRemainingCap() >= line.computeTotalWeight()) {
                                        order.addLine(line);
                                        System.out.println("OK:change_completed");
                                    } else {
                                        System.out.println("ERROR:drone_cant_carry_new_item");
                                    }

                                } else {
                                    System.out.println("ERROR:customer_cant_afford_new_item");
                                }

                            }else{
                                System.out.println("ERROR:item_already_ordered");
                            }

                            }else{
                            System.out.println("ERROR:item_identifier_does_not_exist");
                        }
                        }else{
                            System.out.println("ERROR:order_identifier_does_not_exist");
                        }
                    }else{
                        System.out.println("ERROR:store_identifier_does_not_exist");
                    }

                } else if (tokens[0].equals("purchase_order")) {
                    if ( stores.containsKey(tokens[1])) {
                        Store store = stores.get(tokens[1]);
                        if (store.getOrders().containsKey(tokens[2])){
                            Order order = store.getOrders().get(tokens[2]);
                            Drone drone = store.getDrones().get(order.getDroneId());
                            Customer customer = customers.get(order.getCustomerAccount());
                            if(drone.getAssignPilot() != null) {
                                if (drone.getLeftTrip() > 0){
                                    drone.deliverOrder(order.getOrderId());
                                    int totalCost = order.computePrice();
                                    store.setRevenue(store.getRevenue() + totalCost);
                                    customer.setCredit(customer.getCredit() - totalCost);
                                    store.removeOrder(order.getOrderId());
                                    drone.removeOrder(order.getOrderId());
                                    customer.removeOrder(order.getOrderId());
                                    System.out.println("OK:change_completed");
                                }else{
                                    System.out.println("ERROR:drone_needs_fuel");
                                }
                            }else {
                                System.out.println("ERROR:drone_needs_pilot");

                            }
                        }else {
                            System.out.println("ERROR:order_identifier_does_not_exist");
                        }
                    }else {
                        System.out.println("ERROR:store_identifier_does_not_exist");
                    }

                } else if (tokens[0].equals("cancel_order")) {
                    if (stores.containsKey(tokens[1])) {
                        Store store = stores.get(tokens[1]);
                        if (store.getOrders().containsKey(tokens[2])){
                            Order order = store.getOrders().get(tokens[2]);
                            Customer customer = customers.get(order.getCustomerAccount());
                            Drone drone = store.getDrones().get(order.getDroneId());
                            store.removeOrder(order.getOrderId());
                            drone.removeOrder(order.getOrderId());
                            customer.removeOrder(order.getOrderId());
                            System.out.println("OK:change_completed");
                        }else {
                            System.out.println("ERROR:order_identifier_does_not_exist");
                        }
                    }else{
                        System.out.println("ERROR:store_identifier_does_not_exist");
                    }

                } else if (tokens[0].equals("stop")) {
                    System.out.println("stop acknowledged");
                    break;

                }
//                else {
//                    System.out.println("command " + tokens[0] + " NOT acknowledged");
//                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println();
            }
        }

        System.out.println("simulation terminated");
        commandLineInput.close();
    }
}
