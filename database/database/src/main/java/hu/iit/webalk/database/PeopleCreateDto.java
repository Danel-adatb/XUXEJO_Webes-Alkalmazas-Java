package hu.iit.webalk.database;

public class PeopleCreateDto {
	private String name;
	private int age;
	
	public PeopleCreateDto() {
		super();
	}

	public PeopleCreateDto(People people) {
		this.name = people.getName();
		this.age = people.getAge();
	}

	public static Object toPeople() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
