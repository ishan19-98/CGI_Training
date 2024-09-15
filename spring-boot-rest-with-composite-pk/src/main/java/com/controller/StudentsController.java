package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Students;
import com.service.StudentsService;

@RestController
@RequestMapping("students")
public class StudentsController {
	
	@Autowired
	StudentsService studentsService;
	
	@PostMapping(value = "store", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String StoreStudent(@RequestBody Students student)
	{
		return studentsService.store(student);
	}
	
	@GetMapping(value = "findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Students> FindAllStudent()
	{
		return studentsService.findAll();
	}

}
