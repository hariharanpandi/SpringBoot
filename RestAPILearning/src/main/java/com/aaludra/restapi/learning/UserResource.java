package com.aaludra.restapi.learning;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	private UserService userService;
	
	 UserResource (UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping("/user")
	public List<Users> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("/user/{id}")
	public Users findOne(@PathVariable int id){
		Users user= userService.findOne(id);
		if (user==null) {
			throw new UserNotFoundException("id"+id);
		}
		return user;
	}
	
	@PostMapping("/addusers")
	public ResponseEntity<Users> createUser(@RequestBody Users user) {
		Users saved =userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(location ).build();
	}
}
