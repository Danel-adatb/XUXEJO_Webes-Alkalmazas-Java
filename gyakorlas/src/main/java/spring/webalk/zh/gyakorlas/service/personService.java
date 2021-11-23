package spring.webalk.zh.gyakorlas.service;

/*
 * These class files are used to write business logic in a different layer, 
 * separated from @RestController class file. The logic for creating a 
 * service component class file is shown here −
 */

/*
 * In Java, a service is defined by a set of interfaces and classes. 
 * The service contains an interface or an abstract class that defines 
 * the functionality provided by the service. There are multiple implementations 
 * for a service and they are called as service providers.
 */

public interface personService {
	Iterable<person> getAllPerson();
	person create(person toPerson);
	void delete(long id);
	person getById(long id);
	void save(person person);
	Iterable<? extends person> findByAgeGreaterThan(int age);
}
