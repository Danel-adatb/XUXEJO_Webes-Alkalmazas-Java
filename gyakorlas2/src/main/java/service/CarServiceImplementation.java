package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import repository.CarRepository;

@Service
public class CarServiceImplementation implements CarService{
	private final CarRepository carRepository;
	
	public CarServiceImplementation(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	@Override
	public Iterable<Car> getAllCars() {
		List<Car> rv = new ArrayList<>();
		for(repository.Car car : carRepository.findAll()) {
			rv.add(new Car(car));
		}
		
		return rv;
	}

	@Override
	public Car create(Car toCar) {
		return new Car(carRepository.save(toCar.toEntity()));
	}

	@Override
	public void delete(Long id) {
		try {
			carRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NoSuchEntityExpection(id);
		}
	}

	@Override
	public Car getById(Long id) {
		Optional<repository.Car> optionalCar = carRepository.findById(id);
		
		if(optionalCar.isEmpty()) {
			throw new NoSuchEntityExpection(id);
		}
		
		return new Car(optionalCar.get());
	}

	@Override
	public void save(Car car) {
		Optional<repository.Car> optionalCar = carRepository.findById(car.getId());
		
		if(optionalCar.isEmpty()) {
			throw new NoSuchEntityExpection(car.getId());
		}
		
		carRepository.save(car.toEntity());
	}

	@Override
	public Iterable<? extends Car> findFiveCylinderCarsOverTwoLitre(int engine) {
		return StreamSupport.stream(carRepository.findFiveCylinderCarsOverTwoLitre(engine).spliterator(), false)
				.map(Car::new)
				.collect(Collectors.toList());
	}
	
}
