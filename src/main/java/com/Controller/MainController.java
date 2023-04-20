package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entities.Tasks;
import com.Entities.User;
import com.Exceptions.UserException;
import com.Services.UserService;

@RestController
public class MainController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = userService.createUser(user);
		return new ResponseEntity<User>(savedUser,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/task/{email}")
	public ResponseEntity<Tasks> creatTask(@PathVariable String email, @RequestBody Tasks task) throws UserException{
		Tasks createdTasks = userService.createTask(email, task);
		return new ResponseEntity<Tasks>(createdTasks,HttpStatus.ACCEPTED);
	}
	
	@CrossOrigin
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.ACCEPTED);
	}
}
