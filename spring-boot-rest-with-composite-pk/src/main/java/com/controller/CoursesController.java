package com.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Courses;
import com.service.CoursesService;

@RestController
@RequestMapping("courses")
public class CoursesController {
	
	@Autowired
	CoursesService coursesService;
	
	@PostMapping(value = "store", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String StoreCourse(@RequestBody Courses student)
	{
		return coursesService.store(student);
	}
	
	@GetMapping(value = "findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Courses> FindAllCourses()
	{
		return coursesService.findAll();
	}

}
