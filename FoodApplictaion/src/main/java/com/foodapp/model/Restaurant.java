package com.foodapp.model;

public class Restaurant {
    private int rid;
    private String name;
    private String type;
    private String address;
    private int deliverytime;
    private String ratings;
    private String active;

    // Getters and Setters
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(int deliverytime) {
        this.deliverytime = deliverytime;
    }

    public String getRatings() {
        return ratings;   
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    // Constructors
    public Restaurant() {
    }

    public Restaurant(int rid, String name, String type, String address, int deliverytime, String ratings, String active) {
        this.rid = rid;
        this.name = name;
        this.type = type;
        this.address = address;
        this.deliverytime = deliverytime;
        this.ratings = ratings;
        this.active = active;
    }
    

    public Restaurant(String name, String type, String address, int deliverytime, String ratings, String active) {
		super();
		this.name = name;
		this.type = type;
		this.address = address;
		this.deliverytime = deliverytime;
		this.ratings = ratings;
		this.active = active;
	}    

	@Override
    public String toString() {
        return "Restaurant [rid=" + rid + ", name=" + name + ", type=" + type + ", address=" + address
                + ", deliverytime=" + deliverytime + ", ratings=" + ratings + ", active=" + active + "]";
    }
}

