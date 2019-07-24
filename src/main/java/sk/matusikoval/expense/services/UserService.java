package sk.matusikoval.expense.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.matusikoval.expense.entities.User;
import sk.matusikoval.expense.exceptions.UserAlreadyExistsException;
import sk.matusikoval.expense.exceptions.UserNotFoundException;
import sk.matusikoval.expense.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getUserById(Long userId) throws UserNotFoundException {
		if(!userRepository.existsById(userId))
			throw new UserNotFoundException("User with ID = " + userId + " not found.");
		return userRepository.findById(userId).get();
	}	
	
	public User getUserByUsername(String name) throws UserNotFoundException {
		User u = userRepository.findByUsername(name);
		if(u == null)
			throw new UserNotFoundException("User " + name + " not found.");
		return u;
	}	

	public List<User> getAllUsers() {
		List<User> list = new ArrayList<>();
		userRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	public void addUser(User user) throws UserAlreadyExistsException {	
        User u = userRepository.findByUsername(user.getUsername()); 	
        if (u != null) 
        	 throw new UserAlreadyExistsException("User " + user.getUsername() + " already exists.");
        else 
        	userRepository.save(user);
	}

	public void updateUser(Long userId, User user) throws UserNotFoundException {
        User u = userRepository.findById(userId).orElseThrow(() -> 
        	new UserNotFoundException("Update user with ID = " + userId + " failed. || User not found."));
		u.setIdU(userId);
        u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		u.setRole(user.getRole());
		userRepository.save(u);
	}

	public void deleteUser(Long userId) throws UserNotFoundException {
		User u = userRepository.findById(userId).orElseThrow(() -> 
			new UserNotFoundException("Delete user with ID = " + userId + " failed || User not found."));
		userRepository.delete(u);
	}
}
