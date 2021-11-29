package repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	Iterable<User> findAdultUsers(int age);
}
