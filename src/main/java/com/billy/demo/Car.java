package com.billy.demo;

public class Car {

	private Long id;
	private String make;
	private String model;
	private String color;

	public Car() {}
	
	public Car(String make) {
		this.make = make;
	}

	public Car(String make, String model, String color) {
		this.make = make;
		this.model = model;
		this.color = color;
	}
	
	public Car(Long id, String make, String model, String color) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.color = color;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + ", color=" + color + "]";
	}
	
}