package com.example.course.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.course.entity.AaludraCourse;

public interface AaludraRepository extends JpaRepositoryImplementation<AaludraCourse, Long> {

}
