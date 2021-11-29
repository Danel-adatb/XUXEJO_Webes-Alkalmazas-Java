package service;

public interface UserService {
	Iterable<User> getAllUsers();
	User create(User user);
	void delete(Long id);
	User getById(Long id);
	void save(User user);
	Iterable<? extends User> findAdultUsers(int age);
	
}
