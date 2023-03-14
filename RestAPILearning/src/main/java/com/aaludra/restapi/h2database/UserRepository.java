package com.aaludra.restapi.h2database;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.aaludra.restapi.users.Users;

public interface UserRepository extends JpaRepositoryImplementation<Users, Integer> {

}
