package spring.webalk.zh.gyakorlas.service;

public class person {
	private long id;
	private String name;
	private int age;
	
	public person(long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public person(spring.webalk.zh.gyakorlas.model.person person) {
		this.id = person.getId();
		this.name = person.getName();
		this.age = person.getAge();
	}
	public spring.webalk.zh.gyakorlas.model.person toEntity() {
		return new spring.webalk.zh.gyakorlas.model.person(id, name, age); 
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
