package repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository extends PagingAndSortingRepository<Car, Long>{
	Iterable<Car> findFiveCylinderCarsOverTwoLitre(int engine);
}
