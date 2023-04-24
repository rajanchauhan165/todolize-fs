package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entities.User;
import com.Repository.UserRepo;

@RestController
public class LoginController {
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping("/signin")
	public ResponseEntity<User> loggedInCustomerDetails(org.springframework.security.core.Authentication auth){
		System.out.println(auth.getName());
		User user = userRepo.findByEmail(auth.getName()).orElseThrow(()-> new BadCredentialsException("Wrong credentials"));
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
	}
}
