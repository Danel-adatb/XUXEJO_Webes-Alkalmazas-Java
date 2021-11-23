package spring.webalk.zh.gyakorlas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import spring.webalk.zh.gyakorlas.excpetions.NoSuchEntity;
import spring.webalk.zh.gyakorlas.model.personRepository;

/*
 * Spring @Service annotation is a specialization of @Component annotation. 
 * Spring Service annotation can be applied only to classes. It is used to
 *  mark the class as a service provider.
 *  
 *  Spring @Service annotation is used with classes that provide some business 
 *  functionalities. Spring context will autodetect these classes when annotation-based 
 *  configuration and classpath scanning is used.
 */

/*
 * Azaz implementálja és 'lényeget ad' azoknak a metódusoknak amit a Service fileban létrehoztunk
 * Vagyis előre definiált metódusokat Override-olunk és 'feltöltjük a gerincét'
 */

@Service
public class personServiceImplementation implements personService {
	private final personRepository personRepository;
	
	public personServiceImplementation(personRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@Override
	public Iterable<person> getAllPerson() {
		List<person> persons = new ArrayList<>();
		for(spring.webalk.zh.gyakorlas.model.person person: personRepository.findAll()) {
			persons.add(new person(person));
		}
		
		return persons;
	}

	@Override
	public person create(person person) {
		return new person(personRepository.save(person.toEntity()));
	}

	@Override
	public void delete(long id) {
		try {
			personRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NoSuchEntity(id);
		}
	}
	
	//Ugyanazt tudja mint a fenti metódus csak a lent magyarázott Iterable Objecttel
	public Iterable<person> getAllPerson_Iterable() {
		return StreamSupport.stream(personRepository.findAll().spliterator(), false)
				.map(person::new)
				.collect(Collectors.toList());
	}

	//Optional a NullPointerException kivédésére hozték létre a Java 8-ban
	@Override
	public person getById(long id) {
		Optional<spring.webalk.zh.gyakorlas.model.person> optionalPerson = personRepository.findById(id);
		
		if(optionalPerson.isEmpty()) {
			throw new NoSuchEntity(id);
		}
		
		return new person(optionalPerson.get());
	}

	@Override
	public void save(person person) {
		Optional<spring.webalk.zh.gyakorlas.model.person> optionalPerson = personRepository.findById(person.getId());
		
		if(optionalPerson.isEmpty()) {
			throw new NoSuchEntity(person.getId());
		}
		
		personRepository.save(person.toEntity());
	}

	/*
	*   A Map is an object that maps keys to values. A map cannot contain duplicate keys: Each key can map to at most one value. 
	*   It models the mathematical function abstraction. The Map interface includes methods for basic operations 
	*   (such as put, get, remove, containsKey, containsValue, size, and empty), bulk operations (such as putAll and clear), 
	*   and collection views (such as keySet, entrySet, and values).
	*	
	*	The Java platform contains three general-purpose Map implementations: HashMap, TreeMap, and LinkedHashMap. 
	*	Their behavior and performance are precisely analogous to HashSet, TreeSet, and LinkedHashSet, as described in The Set Interface section.
	*	The remainder of this page discusses the Map interface in detail. But first, 
	*	here are some more examples of collecting to Maps using JDK 8 aggregate operations. 
	*	Modeling real-world objects is a common task in object-oriented programming, so it is 
	*	reasonable to think that some programs might, for example, group employees by department:

	*	// Group employees by department
	*	Map<Department, List<Employee>> byDept = employees.stream()
	*	.collect(Collectors.groupingBy(Employee::getDepartment));
	*/
	
	/*
	 * StreamSupport
	 * This class is mostly for library writers presenting stream views of data structures; 
	 * most static stream methods intended for end users are in the various Stream classes.
	 */
	
	/*
	 * .stream(spliterator, parallel)
	 * Introduced in Java 8, the Stream API is used to process collections of objects. 
	 * A stream is a sequence of objects that supports various methods which can 
	 * be pipelined to produce the desired result.
	 * 
	 * .map(): The map method is used to returns a stream consisting of the results of applying the given function to the elements of this stream.
	 * List number = Arrays.asList(2,3,4,5);
	 * List square = number.stream().map(x->x*x).collect(Collectors.toList());
	 * 
	 * collect: The collect method is used to return the result of the intermediate operations performed on the stream.
	 * List number = Arrays.asList(2,3,4,5,3);
	 * Set square = number.stream().map(x->x*x).collect(Collectors.toSet());
	 */
	
	@Override
	public Iterable<? extends person> findByAgeGreaterThan(int age) {
		return StreamSupport.stream(personRepository.findAllByAgeGreaterThanEqual(age).spliterator(), false)
				.map(person::new)
				.collect(Collectors.toList());
	}


}
