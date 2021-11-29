package repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {
	@GeneratedValue
	@Id
	private long id;
	private String brand;
	private String type;
	private int engine;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Car(long id, String brand, String type, int engine) {
		this.id = id;
		this.brand = brand;
		this.type = type;
		this.engine = engine;
	}
	
	public Car() {
		
	}

}
