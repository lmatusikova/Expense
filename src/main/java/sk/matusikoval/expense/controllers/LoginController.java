package sk.matusikoval.expense.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.matusikoval.expense.entities.User;
import sk.matusikoval.expense.exceptions.UserNotFoundException;
import sk.matusikoval.expense.services.TokenService;
import sk.matusikoval.expense.services.UserService;

@RestController
@RequestMapping("login")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;
	
	
	@PostMapping("/signin")
    public String signIn(@RequestBody User user) throws UserNotFoundException {
		User u = userService.getUserByUsername(user.getUsername());
		System.out.println(u.toString());
		String token = tokenService.generateToken(u);
		System.out.println(token.toString());
		return token;
    }
	
	@PostMapping("/signout")
    public User signOut(@RequestBody User user) {
		User u = userService.getUserByUsername(user.getUsername());
		return u;
    }
			
}
