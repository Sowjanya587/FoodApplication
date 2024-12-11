package com.foodapp.model;

public class Menu
{
	private int mid;
	private int rid;
	private String name;
	private String description;
	private int price;
	private int ratings;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public Menu(int mid, int rid, String name, String description, int price, int ratings) {
		super();
		this.mid = mid;
		this.rid = rid;
		this.name = name;
		this.description = description;
		this.price = price;
		this.ratings = ratings;
	}
	public Menu() {
		super();
	}
	public Menu(int rid, String name, String description, int price, int ratings) {
		super();
		this.rid = rid;
		this.name = name;
		this.description = description;
		this.price = price;
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", rid=" + rid + ", name=" + name + ", description=" + description + ", price="
				+ price + ", ratings=" + ratings + "]";
	}
	
	

}
