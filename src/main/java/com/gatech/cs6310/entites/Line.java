package com.gatech.cs6310.entites;






public class Line {

    private Integer quantity;
    private Integer unit_price;
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Line(Item item,Integer unit_price,Integer quantity){
        this.item = item;
        this.unit_price = unit_price;
        this.quantity = quantity;

    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Integer unit_price) {
        this.unit_price = unit_price;
    }

    public Integer computeTotalWeight(){
        return item.getWeight()*this.quantity;
    }

    public Integer computeTotalPrice(){
        return this.quantity*this.unit_price;
    }

    public void displayLine(){
        System.out.println("item_name:" + this.getItem().getItemName() + ",total_quantity:" + this.getQuantity()
                + ",total_cost:" + this.computeTotalPrice() + ",total_weight:" + this.computeTotalWeight());
    }
}
