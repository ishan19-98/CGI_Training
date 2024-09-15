package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Courses;
import com.repository.CoursesRepository;

@Service
public class CoursesService {
	
	@Autowired
	CoursesRepository coursesRepository;
	
	public String store(Courses course)
	{
		Optional<Courses> ct = coursesRepository.findById(course.getCid());
		if(ct.isPresent())
		{
			return "Course Already Exists With Given Id";
		}
		else
		{
			coursesRepository.save(course);
			return "Course Record Saved Succesfully";
		}
	}
	
	public List<Courses> findAll()
	{
		return coursesRepository.findAll();
	}

}
