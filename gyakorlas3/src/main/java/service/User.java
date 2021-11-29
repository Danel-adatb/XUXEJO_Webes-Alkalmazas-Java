package service;

public class User {
	private Long id;
	private String lastname;
	private String firstname;
	private int age;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User(Long id, String lastname, String firstname, int age) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.age = age;
	}
	
	public User(repository.User user) {
		this.id  = user.getId();
		this.firstname = user.getFirstname();
		this.lastname = user.getLastname();
		this.age = user.getAge();
	}
	
	public repository.User toEntity() {
		return new repository.User(id, firstname, lastname, age);
	}
	
}
