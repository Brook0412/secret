package com.model.bean;


public class Commodity {
	
	private Integer id;
	private String name;
	private String price;
	private String stock;
	private String details;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Commodity(String name, String price, String stock, String details) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.details = details;
	}
}
