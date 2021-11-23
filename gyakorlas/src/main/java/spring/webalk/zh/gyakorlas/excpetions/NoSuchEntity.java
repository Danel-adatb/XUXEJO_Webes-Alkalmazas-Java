package spring.webalk.zh.gyakorlas.excpetions;

public class NoSuchEntity extends RuntimeException{
	private long id;

	public NoSuchEntity(long id) {
		super(String.format("No such Entity", id));
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
}
