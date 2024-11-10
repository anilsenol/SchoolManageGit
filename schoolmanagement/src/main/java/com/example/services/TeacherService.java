package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entities.Teacher;
import com.example.repository.ITeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private ITeacherRepository teacherRepository;
	
	public Teacher saveTeacher(Teacher newTeacher) {
		return teacherRepository.save(newTeacher);
	}
	
	public List<Teacher> getTeacherByFirstName(String firstName){
		return teacherRepository.findByFirstName(firstName);
	}
	
	public Optional<Teacher> getTeacherById(int id) {
		return teacherRepository.findById(id);
	}
	
	
}
