package hu.iit.webalk.database;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public interface PeopleRepository extends PagingAndSortingRepository<People, Long>{
	
}
