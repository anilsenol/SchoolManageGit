package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer>{
	
    @Query("SELECT s FROM Student s WHERE TRIM(LOWER(s.firstName)) = TRIM(LOWER(:firstName))")
	List<Student> findByFirstName(String firstName);
}