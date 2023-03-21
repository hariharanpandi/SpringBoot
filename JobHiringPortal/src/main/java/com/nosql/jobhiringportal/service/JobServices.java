package com.nosql.jobhiringportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nosql.jobhiringportal.model.ListOfJob;
import com.nosql.jobhiringportal.repository.DepartmentRepository;
import com.nosql.jobhiringportal.repository.JobRepository;

@Service
public class JobServices {

	@Autowired
	JobRepository repository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public ListOfJob createjob (ListOfJob listOfJob) {
		if (listOfJob.getDepartment()!= null) {
			departmentRepository.save(listOfJob.getDepartment());
		}
		return repository.save(listOfJob);
	}

	public List<ListOfJob> findAll() {
		return repository.findAll();
	}

	public ListOfJob findbyid(String id) {
		return repository.findById(id).get();
	}

	public List<ListOfJob> getbyname(String name) {
		return repository.findByName(name);
	}

	public ListOfJob update(ListOfJob listOfJob) {
		return repository.save(listOfJob);
	}

	public String delete(String id) {
		repository.deleteById(id);
		return "deleted !";
	}

	public List<ListOfJob> getbydept(String departmentname) {
		return repository.findByDepartmentDepartmentname(departmentname);
	}

	public List<ListOfJob> nameAndProfile(String name, String profile) {
		return repository.findByNameAndProfile(name, profile);
	}

	public List<ListOfJob> profilesname(String name, String profile) {
		return repository.findByProfileOrName(name, profile);
	}

	public List<ListOfJob> pageable(int pageno, int pagesize) {
		Pageable pageable = PageRequest.of(pageno-1, pagesize);
		return repository.findAll(pageable).getContent();
	}

	public List<ListOfJob> sorting() {
		Sort sort= Sort.by(Sort.Direction.ASC, "name");
		return repository.findAll(sort);
	}

	public List<ListOfJob> skillarray(String skill) {

		return repository.findBySkill(skill);
	}

	public List<ListOfJob> likequery(String description) {
		return repository.findByDescriptionIsLike(description);
	}
	
	public List<ListOfJob> getbydeptId(String departmentId) {
		return repository.findByDepartmentId(departmentId);
	}
}
