package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	private final UserRepository userRepository;
	
	public UserServiceImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
		
	@Override
	public Iterable<User> getAllUsers() {
		List<User> rv = new ArrayList<>();
		
		for(repository.User user : userRepository.findAll()) {
			rv.add(new User(user));
		}
		
		return rv;
	}

	@Override
	public User create(User user) {
		return new User(userRepository.save(user.toEntity()));
	}

	@Override
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch(EmptyResultDataAccessException ex) {
			throw new NoSuchEntityExpection(id);
		}
	}

	@Override
	public User getById(Long id) {
		Optional<repository.User> optionalUser = userRepository.findById(id);
		
		if(optionalUser.isEmpty()) {
			throw new NoSuchEntityExpection(id);
		}
		
		return new User(optionalUser.get());
	}

	@Override
	public void save(User user) {
		Optional<repository.User> optionalUser = userRepository.findById(user.getId());
		
		if(optionalUser.isEmpty()) {
			throw new NoSuchEntityExpection(user.getId());
		}
		
		userRepository.save(user.toEntity());
	}

	@Override
	public Iterable<? extends User> findAdultUsers(int age) {
		return StreamSupport.stream(userRepository.findAll().spliterator(), false)
				.map(User::new)
				.collect(Collectors.toList());
	}

}
