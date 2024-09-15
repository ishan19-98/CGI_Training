package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Enrollment;
import com.entity.EnrollmentKey;
import com.service.EnrollmentService;

@RestController
@RequestMapping("enrollment")
public class EnrollmentController {
	
	@Autowired
	EnrollmentService enrollmentService;
	
	@PostMapping(value = "store", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String StoreStudent(@RequestBody Enrollment enrollment)
	{
		return enrollmentService.store(enrollment);
	}
	
	@GetMapping(value = "findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Enrollment> FindAllStudent()
	{
		return enrollmentService.findAll();
	}

}
