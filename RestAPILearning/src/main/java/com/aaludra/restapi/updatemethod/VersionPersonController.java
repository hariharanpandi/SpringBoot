package com.aaludra.restapi.updatemethod;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionPersonController {

	@GetMapping("/v1/person")
	public Person findperson() {
		return new Person("Hari"); 
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getname() {
		return new PersonV2(new Name("Bob", "Charli"));
	}

	@GetMapping(path = "/person", params = "Version=1")
	public Person findpersonparameter() {
		return new Person("Hari"); 
	}
	
	@GetMapping(path = "/person", params = "Version=2")
	public PersonV2 getnameparameter() {
		return new PersonV2(new Name("Bob", "Charli"));
	}
	
	@GetMapping(path = "/person/header", headers = "API-version=1")
	public Person getnamefromheader() {
		return new Person("Pradeep Kumar");
	} 
	
	@GetMapping(path = "/person/header", headers = "API-version=2"  )
	public PersonV2 getnamefromheaders() {
		return new PersonV2(new Name("Pradeep", "Kumar"));
	}
	
	@GetMapping(path = "/person/header", produces = "application/vnd.company.app-v1+json")
	public Person getnamefromacceptheader() {
		return new Person("Pradeep Kumar");
	} 

	@GetMapping(path = "/person/header", produces = "application/vnd.company.app-v2+json" )
	public PersonV2 getnamefromacceptheaders() {
		return new PersonV2(new Name("Pradeep", "Kumar"));
	}
}
