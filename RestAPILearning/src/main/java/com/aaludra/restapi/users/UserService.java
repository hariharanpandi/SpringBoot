package com.aaludra.restapi.users;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserService {

	private static List<Users> user = new ArrayList<>();

	private static int userId=0;
	static {
		user.add(new Users("Hari", ++userId, "Software Trainee"));
		user.add(new Users("Arun", ++userId, "Software Tester"));
		user.add(new Users("Guna", ++userId, "Software Developer"));
	}

	public List<Users> findAll() {
		return user;
	}

	public Users findOne(int id) {
		Predicate<? super Users> Predicate = Users -> Users.getId() == id;
		return user.stream().filter(Predicate).findFirst().orElse(null);
	}

	public Users save(Users users) {
		users.setId(++userId);
		user.add(users);
		return users;
	}
	
	public void deleteById(int id) {
		Predicate<? super Users> predicate= users -> users.getId()==id;
		user.removeIf(predicate);
	}
}
