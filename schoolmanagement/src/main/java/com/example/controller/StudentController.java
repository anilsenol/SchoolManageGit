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

import com.example.entities.Student;

import com.example.services.StudentService;

@RestController
@RequestMapping("/rest/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@PostMapping(path = "/save")
	public Student saveStudent(@RequestBody Student newStudent) {
	    return studentService.saveStudent(newStudent);
	}
	
	@GetMapping(path = "/all")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/firstname")
	public List<Student> getStudentByFirstName(@RequestParam String firstName){
		return studentService.getStudentsByFirstName(firstName);
	}
	
	@GetMapping("/{id}")
	public Optional<Student> getStudentById(@PathVariable Integer id) {
		return studentService.getStudentById(id);
	}
	

	
}
