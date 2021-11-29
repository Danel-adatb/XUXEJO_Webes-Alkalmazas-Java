package controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import service.Car;
import service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	private final CarService carService;
	
	public CarController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping
	public Iterable<CarDTO> getAllCars() {
		List<CarDTO> rv = new ArrayList<>();
		for(Car car: carService.getAllCars()) {
			rv.add(new CarDTO(car));
		}
		
		return rv;
	}
	
	@PostMapping(consumes="application/json")
	public CarDTO create(@RequestBody @Valid CarCreateDTO carCreateDTO) {
		return new CarDTO(carService.create(carCreateDTO.toCar()));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		carService.delete(id);
	}
	
	@GetMapping("/{id}")
	public CarDTO getById(@PathVariable("id") Long id) {
		return new CarDTO(carService.getById(id));
	}
	
	@PutMapping
	void save(@RequestBody @Valid CarDTO carDTO) {
		carService.save(carDTO.toCar());
	}
	
	@GetMapping("/findFiveCylinderCarsOverTwoLitre")
	Iterable<CarDTO> findFiveCylinderCarsOverTwoLitre(@RequestParam("engine") int engine) {
		List<controller.CarDTO> rv = new ArrayList<>();
		for (Car car : carService.findFiveCylinderCarsOverTwoLitre(engine)) {
			rv.add(new controller.CarDTO(car));
		}
		
		return rv;
	}
}
