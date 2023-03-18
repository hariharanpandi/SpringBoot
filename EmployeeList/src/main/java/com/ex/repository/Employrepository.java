package com.ex.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.model.Employentity;

@Repository
public interface Employrepository extends JpaRepository<Employentity, Integer>{

}

