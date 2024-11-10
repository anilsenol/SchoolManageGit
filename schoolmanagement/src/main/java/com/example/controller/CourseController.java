package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Course;
import com.example.services.CourseService;

@RestController
@RequestMapping("/rest/api/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping(path = "/save")
	public Course saveCourse(@RequestBody Course newCourse) {
		return courseService.saveCourse(newCourse);
	}
	
	@GetMapping("/{id}")
	public Optional<Course> getCourseById(@PathVariable int id){
		return courseService.getCourseById(id);
	}
	
	
}
