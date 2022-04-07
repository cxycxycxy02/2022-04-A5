package com.gatech.cs6310.entites;


public class Item {
    private String itemName;
    private Integer weight;

    private String store;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getStore() {
        return store;
    }

    public Item(String store,String itemName,Integer weight){
        this.store = store;
        this.itemName = itemName;
        this.weight = weight;
    }

    public void setStore(String store) {
        this.store = store;
    }
    public void displayItem(){
        System.out.println(this.getItemName() + "," + this.getWeight());
    }
}
