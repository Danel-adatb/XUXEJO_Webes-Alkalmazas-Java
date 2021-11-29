package service;

public interface CarService {
	Iterable<Car> getAllCars();
	Car create(Car toCar);
	void delete(Long id);
	Car getById(Long id);
	void save(Car car);
	Iterable<? extends Car> findFiveCylinderCarsOverTwoLitre(int engine);
}
