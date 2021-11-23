package spring.webalk.zh.gyakorlas.dao;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import spring.webalk.zh.gyakorlas.service.person;

/*
 * @NotEmpty, @NotNull, @NotBlank
 * Bean Validation is a standard validation specification 
 * that allows us to easily validate domain objects by 
 * using a set of constraints declared in the form of annotations.
 */

public class personDTO {
	private long id;
	/*
	 * The @NotEmpty annotation makes use of the @NotNull class' isValid() implementation, 
	 * and also checks that the size/length of the supplied object (of course, this varies 
	 * according to the type of object being validated) is greater than zero.
	 *
	 * In a nutshell, this means that a field (e.g. CharSequence, Collection, Map, or Array) 
	 * constrained with @NotEmpty must be not null, and its size/length must be greater than zero.
	 */
	@NotEmpty
	private String name;
	/*
	 * @Min(x) annotation is used to limit the value of a field to a minimum value.
	 */
	@Min(18)
	private int age;
	
	public personDTO() {
		
	}
	
	public personDTO(person person) {
		this.id = person.getId();
		this.name = person.getName();
		this.age = person.getAge();
	}
	
	public person toPerson() {
		return new person(id, name, age);
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
