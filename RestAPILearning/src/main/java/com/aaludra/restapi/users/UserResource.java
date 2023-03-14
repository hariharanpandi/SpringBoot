package com.aaludra.restapi.users;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {
		Users saved =userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(saved.getId()).toUri();
		return ResponseEntity.created(location ).build();
	}
	
	@DeleteMapping("/userid/{id}")
	public void deleteuser(@PathVariable int id) {
		userService.deleteById(id);
	}
	
	@GetMapping("/user-link/{id}")
	public EntityModel<Users> findOnegetlink(@PathVariable int id){
		Users user= userService.findOne(id);
		if (user==null) {
			throw new UserNotFoundException("id"+id);
		}
		EntityModel<Users> entitymodel=EntityModel.of(user);
		WebMvcLinkBuilder link=WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).findAll());
		entitymodel.add(link.withRel("find-All-Users"));
		
		return entitymodel;
	}
}
