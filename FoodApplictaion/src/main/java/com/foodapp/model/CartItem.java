package com.foodapp.model;

public class CartItem {
    private int itemid;
    private int rid;
    private String name;
    private int quantity;
    private int price;

    // Default constructor
    public CartItem() {
        super();
    }

    // Constructor with all fields
    public CartItem(int itemid, int rid, String name, int quantity, int price) {
        super();
        this.itemid = itemid;
        this.rid = rid;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Constructor without itemid
    public CartItem(int rid, String name, int quantity, int price) {
        super();
        this.rid = rid;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Dynamically compute total price
    public double getTotalPrice() {
        return this.quantity * this.price;
    }

    @Override
    public String toString() {
        return "CartItem [itemid=" + itemid + ", rid=" + rid + ", name=" + name + 
               ", quantity=" + quantity + ", price=" + price + ", totalPrice=" + getTotalPrice() + "]";
    }
}
