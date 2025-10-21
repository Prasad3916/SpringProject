package com.lms.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lms.application.model.Mentors;

@Repository
public interface MentorRepo extends JpaRepository<Mentors, Integer>{
 
}
