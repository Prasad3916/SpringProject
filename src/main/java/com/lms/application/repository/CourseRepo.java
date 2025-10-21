package com.lms.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lms.application.model.Courses;

@Repository
public interface CourseRepo extends JpaRepository<Courses, Integer>{
 
	@Query("SELECT c FROM Courses c WHERE c.mentor.id = :mentorId")
	List<Courses> getCoursesByMentor(@Param("mentorId") int mentorId);
}
