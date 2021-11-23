package spring.webalk.zh.gyakorlas.model;

import org.springframework.data.repository.PagingAndSortingRepository;

/*
 *A repository is a mechanism for encapsulating storage,
 *retrieval, and search behavior which emulates a collection of objects. 
 */

/*
 * These Repositories are Java interfaces that allow you as the developer to define a data access contract.
 */

/*
 *The central interface in Spring Data repository abstraction is Repository (probably not that much of a surprise).
 *It takes the the domain class to manage as well as the id type of the domain class as type arguments.
 *This interface acts primarily as a marker interface to capture the types to work with and to help you 
 *to discover interfaces that extend this one. The CrudRepository provides sophisticated CRUD functionality
 *for the entity class that is being managed.
 */

/*
 * Például ez a metódus az Interface-ben megkeresi az adott évnél idősebb embereket
 */

/*
 * PagingAndSortingRepository is an extension of CrudRepository to provide additional methods to retrieve entities 
 * using the pagination and sorting abstraction. It provides two methods :
 * 1.Page findAll(Pageable pageable) – returns a Page of entities meeting the paging restriction provided in the Pageable object.
 * 2.Iterable findAll(Sort sort) – returns all entities sorted by the given options. No paging is applied here.
 */

public interface personRepository extends PagingAndSortingRepository<person, Long> {
	Iterable<person> findAllByAgeGreaterThanEqual(int age);
}
