package hu.iit.webalk.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeopleService {
	private final PeopleRepository peopleRepository;
	
	public PeopleServiceImpl(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}
	
	@Override
	public Iterable<People> getAllPeople(){
		List<People> rv = new ArrayList<>();
		
		//for (hu.iit.webalk.database.People people, PeopleRepository)
		
		return rv;
		
	}
	
	public People create(People people) {
		//return peopleRepository.save(hu.iit.webalk.database.People people )
		return people;
	}

}
