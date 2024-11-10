package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Course;
import com.example.repository.ICourseRepository;

@Service
public class CourseService {

	@Autowired
	private ICourseRepository courseRepository;
	
	public Course saveCourse(Course newCourse) {
		return courseRepository.save(newCourse);
	}
	
	public Optional<Course> getCourseById(int id){
		return courseRepository.findById(id);
	}
	
}
