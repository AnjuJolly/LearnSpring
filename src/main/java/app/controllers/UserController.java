package app.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.models.User;

@RestController
@RequestMapping("/user")
public class UserController {
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/") 
	public String showHello(){
		return "Hello User";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public User getUser(@RequestParam(name = "id") int userId) {
		User user = new User();
		user.setUserId(counter.incrementAndGet());
		user.setName("Anju");
		user.setAge(33);
		user.setAddress("Vazhakkala");
		return user;
	}
}
