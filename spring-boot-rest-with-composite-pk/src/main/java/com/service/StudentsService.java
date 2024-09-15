package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Students;
import com.repository.StudentsRepository;

@Service
public class StudentsService {
	
	@Autowired
	StudentsRepository studentsRepository;
	
	public String store(Students student)
	{
		Optional<Students> st = studentsRepository.findById(student.getSid());
		if(st.isPresent())
		{
			return "Student Already Exists With Given Id";
		}
		else
		{
			studentsRepository.save(student);
			return "Student Record Saved Succesfully";
		}
	}
	
	public List<Students> findAll()
	{
		return studentsRepository.findAll();
	}

}
