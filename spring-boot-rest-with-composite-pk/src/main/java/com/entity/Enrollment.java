package com.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Transient;

@Entity
public class Enrollment {

@EmbeddedId				// combination of two columns ie sid and cid 	
private EnrollmentKey ek;

@ManyToOne
@MapsId("sid")
@Transient
private Students student;

@ManyToOne
@MapsId("cid")
@Transient
private Courses course;

private int year;

public EnrollmentKey getEk() {
	return ek;
}

public void setEk(EnrollmentKey ek) {
	this.ek = ek;
}

public Students getStudent() {
	return student;
}

public void setStudent(Students student) {
	this.student = student;
}

public Courses getCourse() {
	return course;
}

public void setCourse(Courses course) {
	this.course = course;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

}