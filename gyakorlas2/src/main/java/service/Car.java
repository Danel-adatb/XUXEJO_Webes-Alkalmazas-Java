package service;

public class Car {
	private Long id;
	private String brand;
	private String type;
	private int engine;
	public long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Car(Long id, String brand, String type, int engine) {
		this.id = id;
		this.brand = brand;
		this.type = type;
		this.engine = engine;
	}
	public Car(repository.Car car) {
		this.id = car.getId();
		this.brand = car.getBrand();
		this.type = car.getType();
		this.engine = car.getEngine();
	}
	public repository.Car toEntity() {
		return new repository.Car(id, brand, type, engine);
	}
}
