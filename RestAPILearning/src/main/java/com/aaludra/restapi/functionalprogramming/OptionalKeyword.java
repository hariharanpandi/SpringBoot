package com.aaludra.restapi.functionalprogramming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OptionalKeyword {

	public static void main(String[] args) {

		List<String> courses = List.of("java", "sql", "spring", "spring cloud", "spring boot", "Microservices");
		//courses.stream().filter(course -> course.contains("spring")).forEach(System.out::println);
		
		Predicate<? super String> Predicate= course -> course.startsWith("j");
		Optional<String> optional=courses.stream().filter(Predicate).findAny();
		System.out.println(optional.get());
		System.out.println(optional.isPresent());
		System.out.println(optional.isEmpty());
		System.out.println(optional);
	}
}