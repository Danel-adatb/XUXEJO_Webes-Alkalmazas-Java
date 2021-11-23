package spring.webalk.zh.gyakorlas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * Each entity must have at least two annotations defined: @Entity and @Id. The @Entity annotation 
 * specifies that the class is an entity and is mapped to a database table. The @Table annotation 
 * specifies the name of the database table to be used for mapping. The @Id annotation specifies 
 * the primary key of an entity and the @GeneratedValue provides for the specification of generation 
 * strategies for the values of primary keys.
 */

/*
 * Ez a Model Class, ez adja az esetleges adatbázisnak az alapját.
 * Itt határozzuk meg a modeljét az applikációnknak
 */

@Entity
public class person {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int age;
	
	public person(long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
