package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Course;
import com.example.entities.Teacher;
import com.example.repository.ICourseRepository;
import com.example.services.TeacherService;

@RestController
@RequestMapping("/rest/api/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
    private ICourseRepository courseRepository;

	@PostMapping(path = "/save")
	public Teacher saveTeacher(@RequestBody Teacher newTeacher) {
		if (newTeacher.getCourses() != null) {
            for (Course course : newTeacher.getCourses()) {
                if (course.getId() != 0) {  
                    Course existingCourse = courseRepository.findById(course.getId())
                            .orElseThrow(() -> new RuntimeException("Course not found with ID: " + course.getId()));
                    existingCourse.setTeacher(newTeacher);
                    newTeacher.getCourses().remove(course);  
                    newTeacher.getCourses().add(existingCourse); 
                } else {
                    course.setTeacher(newTeacher);  
                }
            }
        }

		return teacherService.saveTeacher(newTeacher);
	}
	
	@GetMapping(path = "/firstname")
	public List<Teacher> getTeacherByFirstName(@RequestParam String firstName){
		return teacherService.getTeacherByFirstName(firstName);
	}
	
	@GetMapping("/{id}")
	public Optional<Teacher> getTeacherById(@PathVariable Integer id) {
		return teacherService.getTeacherById(id);
	}
}
