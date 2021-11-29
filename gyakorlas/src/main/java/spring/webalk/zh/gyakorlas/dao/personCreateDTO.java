package spring.webalk.zh.gyakorlas.dao;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import spring.webalk.zh.gyakorlas.service.person;

public class personCreateDTO {
	
	@NotEmpty
	private String name;
	
	@Min(18)
	private int age;
	
	public personCreateDTO(person person) {
		this.name = person.getName();
		this.age = person.getAge();
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
	
	public person toPerson() {
		return new person((Long)null, name, age);
	}
	
	
}
