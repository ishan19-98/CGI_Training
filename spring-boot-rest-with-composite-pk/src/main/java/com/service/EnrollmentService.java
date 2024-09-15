package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Courses;
import com.entity.Enrollment;
import com.entity.EnrollmentKey;
import com.entity.Students;
import com.repository.CoursesRepository;
import com.repository.EnrollmentRepository;
import com.repository.StudentsRepository;

@Service
public class EnrollmentService {
	
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	@Autowired
	StudentsRepository studentsRepository;
	
	@Autowired
	CoursesRepository coursesRepository;
	
	public String store(Enrollment enrollment)
	{
		Students student = studentsRepository.findById(enrollment.getEk().getSid())
				.orElseThrow(() -> new RuntimeException("Student not found with id: " + enrollment.getEk().getSid()));
		Courses course = coursesRepository.findById(enrollment.getEk().getCid()).
				orElseThrow(() -> new RuntimeException("Course not found with id: " + enrollment.getEk().getCid()));
		
		List<Enrollment> enrollments = enrollmentRepository.findAll();
		
		for(Enrollment enr: enrollments)
		{
			if((enr.getEk().getCid()==course.getCid()) &&(enr.getEk().getSid()==student.getSid()))
			{
			return "Student is already enrolled for following course!!";
		    }
		}
	
			Enrollment enew = new Enrollment();
			enew.setCourse(course);
			enew.setStudent(student);
			enew.setYear(enrollment.getYear());
			enew.setEk(enrollment.getEk());
			enrollmentRepository.save(enew);
			return "Enrollment Details Saved Successfully.";
			
	}	
	
	
	public List<Enrollment> findAll()
	{
		return enrollmentRepository.findAll();
	}

}
