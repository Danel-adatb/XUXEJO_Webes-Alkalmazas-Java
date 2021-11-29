package controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import service.Car;

public class CarCreateDTO {
	@NotEmpty
	private String brand;
	@NotEmpty
	private String type;
	@Min(800)
	private int engine;
	
	public CarCreateDTO() {
		
	}
	
	public CarCreateDTO(Car car) {
		this.brand = car.getBrand();
		this.type = car.getType();
		this.engine = car.getEngine();
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getEngine() {
		return engine;
	}

	public void setEngine(int engine) {
		this.engine = engine;
	}
	
	public Car toCar() {
		return new Car(null, brand, type, engine);
	}
}
