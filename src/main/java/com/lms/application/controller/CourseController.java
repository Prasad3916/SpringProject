package com.lms.application.controller;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.lms.application.model.Courses;
import com.lms.application.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
 
	@Autowired
	CourseService cs;
	
	@RequestMapping("/")
	@CrossOrigin
	public List<Courses> getCourses(){ 
		return cs.getCourses();
	}  
	 
	@RequestMapping("/{id}")
	@CrossOrigin
	public Courses getCoursesById(@PathVariable int id) {
		return cs.getCoursesById(id);
	}
	
	@PostMapping("/mentor/{id}/addcourses/")
	@CrossOrigin
	public String addCourses(@PathVariable int id,@RequestPart Courses course,
			@RequestPart MultipartFile video) throws IOException {
		return cs.addCourses(id,course, video);
	}
	
	@PutMapping("/updatecourses")
	@CrossOrigin
	public String updateCourses(@RequestPart Courses course,
			@RequestPart MultipartFile video) throws IOException {
		return cs.updateCourses(course, video);

	}
	 
	@RequestMapping("/video/{id}")
	@CrossOrigin
	public ResponseEntity<?> getVideoById(@PathVariable int id){
			return cs.getVideoById(id);
	} 
	 
	@RequestMapping("/ids")
	@CrossOrigin
	public List<Integer> getCoursesIds() { 
		return cs.getCoursesIds();
	}
	
	@GetMapping("/mentor/courses/{id}")
	public List<Courses> getMentorCourse(@PathVariable int id) {
		return cs.getMentorCourse(id); 
	}
	
}
