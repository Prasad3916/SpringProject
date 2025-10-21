package com.lms.application.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.lms.application.model.Courses;
import com.lms.application.model.Mentors;
import com.lms.application.repository.CourseRepo;
import com.lms.application.repository.MentorRepo;

@Service
public class CourseService {

	@Autowired
	CourseRepo cr; 
	
	@Autowired 
	MentorRepo mr;
	
	public List<Courses> getCourses(){  
		return cr.findAll();
	} 
	
	public Courses getCoursesById(int id) {
		Courses Courses = cr.findById(id).orElse(null);
		if(Courses!=null) {
			return Courses;
		}
		return new Courses();
	}
	
	public String addCourses(int id, Courses course,
			 MultipartFile video) throws IOException {
		course.setVideoName(video.getOriginalFilename());
		course.setVideoType(video.getContentType());
		course.setVideoFile(video.getBytes());
		Mentors mentor= mr.findById(id).orElse(null);
		System.out.println(mentor);
		course.setMentor(mentor);
		cr.save(course);
		return "Uploaded Sucessfully"; 
	}
	
	public String updateCourses( Courses course,
			 MultipartFile video) throws IOException {
		course.setVideoName(video.getOriginalFilename());
		course.setVideoType(video.getContentType());
		course.setVideoFile(video.getBytes());
		cr.save(course);
		return "Uploaded Sucessfully";
	}
	
	public ResponseEntity<?> getVideoById(int id){
		Courses course=cr.findById(id).orElse(null);
		if(course!=null) {
			byte[] Video=course.getVideoFile();
			return ResponseEntity.ok()
					.contentType(MediaType.valueOf(course.getVideoType()))
					.body(Video);
		}
		return new ResponseEntity<>("failed",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	public List<Integer> getCoursesIds() {
		List<Courses> course = getCourses();
		List<Integer> list = course.stream().map(e->e.getId()).toList();
		return list;
	}
	
	public List<Courses> getMentorCourse(@PathVariable int id) {
		return cr.getCoursesByMentor(id); 
	}
}
