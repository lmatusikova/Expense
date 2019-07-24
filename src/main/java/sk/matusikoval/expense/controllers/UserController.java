package sk.matusikoval.expense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sk.matusikoval.expense.entities.User;
import sk.matusikoval.expense.exceptions.UserAlreadyExistsException;
import sk.matusikoval.expense.exceptions.UserNotFoundException;
import sk.matusikoval.expense.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
    @GetMapping("/{id}")
    public @ResponseBody User getUserById(@PathVariable("id") Long id) throws UserNotFoundException {  
        return userService.getUserById(id);
    }
    
    @GetMapping("/userbyusername/{username}")
    public @ResponseBody User getUserByUsername(@PathVariable("username") String name) throws UserNotFoundException {  
        return userService.getUserByUsername(name);
    }
	
	@GetMapping
	public @ResponseBody List<User> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return users;
	}
	
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) throws UserAlreadyExistsException {
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable("id") Long id) throws UserNotFoundException {
    	userService.deleteUser(id);
    	return ResponseEntity.ok(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Long> updateUser(@PathVariable("id") Long id, @RequestBody User user) throws UserNotFoundException {
    	userService.updateUser(id, user);
    	return ResponseEntity.ok(id);
    }
}
