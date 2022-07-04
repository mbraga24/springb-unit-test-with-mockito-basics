package com.dev.unittesting.unittesting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Item {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private double price;
	private int quantity;
	
	@Transient
	private int value;
	
	protected Item() {}
	
	public Item(int id, String name, double price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public String toString() {
		return String.format("Item[%d, %s, %d, %d]", id, name, price, quantity);
	}

}
