package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Teacher;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Integer>{

	 @Query("SELECT s FROM Teacher s WHERE TRIM(LOWER(s.firstName)) = TRIM(LOWER(:firstName))")
	List<Teacher> findByFirstName(String firstName);
	
}
