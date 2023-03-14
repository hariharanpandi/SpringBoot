package com.aaludra.restapi.h2database;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.aaludra.restapi.users.UserNotFoundException;
import com.aaludra.restapi.users.Users;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	private UserRepository userRepository;
	private PostRepository postRepository;

	UserJpaResource(PostRepository postRepository, UserRepository userRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	@GetMapping("/jpa/user")
	public List<Users> findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/jpa/user/{id}")
	public Optional<Users> findOne(@PathVariable int id) {
		Optional<Users> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id" + id);
		}
		return user;
	}

	@PostMapping("/jpa/addusers")
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {
		Users saved = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/jpa/userid/{id}")
	public void deleteuser(@PathVariable int id) {
		Optional<Users> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id" + id);
		}
		userRepository.deleteById(id);
	}

	@GetMapping("/jpa/user-link/{id}")
	public EntityModel<Users> findOnegetlink(@PathVariable int id) {
		Optional<Users> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id" + id);
		}
		EntityModel<Users> entitymodel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).findAll());
		entitymodel.add(link.withRel("find-All-Users"));

		return entitymodel;
	}

	@GetMapping("/jpa/users/post/{id}")
	public List<Post> retriveuserfrompost(@PathVariable int id) {
		Optional<Users> user = userRepository.findById(id);
		if (user.isEmpty())
			throw new UserNotFoundException("id" + id);

		return user.get().getPost();
	}

	@PostMapping("/jpa/users/post/{id}/create")
	public List<Post> createUserfromPost(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<Users> user = userRepository.findById(id);

		if (user.isEmpty())
			throw new UserNotFoundException("id " + id);

		post.setUsers(user.get());
		Post savedPost=postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(savedPost).toUri();
		ResponseEntity.created(location );
		return user.get().getPost();
	}
}
