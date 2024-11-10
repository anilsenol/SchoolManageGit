package com.example.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entities.Student;
import com.example.repository.IStudentRepository;

@Service
public class StudentService {

	@Autowired
	private IStudentRepository studentRepository;
	
	public Student saveStudent(Student newStudent) {
		return studentRepository.save(newStudent);
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public List<Student> getStudentsByFirstName(String firstName){
        firstName = firstName != null ? firstName.trim() : null;
		return studentRepository.findByFirstName(firstName);
	}
	
	public Optional<Student> getStudentById( int id) {
		return studentRepository.findById(id);
	}
	
	
	
}
