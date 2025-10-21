package com.lms.application.controller;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.lms.application.model.Students;
import com.lms.application.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService ss;
	
	@RequestMapping("/") 
	@CrossOrigin 
	public List<Students> getStudents(){ 
		return ss.getStudents();
	}  
	 
	@RequestMapping("/{id}")
	@CrossOrigin
	public Students getStudentById(@PathVariable int id) {
		return ss.getStudentById(id);
	}
	
	@PostMapping("/addstudent")
	@CrossOrigin
	public String addStudent(@RequestPart Students student,
			@RequestPart MultipartFile profile) throws IOException {
		return ss.addStudent(student, profile);
	}
	
	@PutMapping("/updatestudent")
	@CrossOrigin
	public String updateStudent(@RequestPart Students student,
			@RequestPart MultipartFile profile) throws IOException {
		return ss.updateStudent(student, profile);

	}
	 
	@GetMapping("/profile/{id}")
	@CrossOrigin
	public ResponseEntity<?> getProfileById(@PathVariable int id){
			return ss.getProfileById(id);
	}
	 
	@RequestMapping("/ids")
	@CrossOrigin
	public List<Integer> getStudentIds() { 
		return ss.getStudentIds();
	}
	
	
	@GetMapping("/{stdid}/course/{courseid}")
	@CrossOrigin
	public String addStudentCourses(@PathVariable int stdid,@PathVariable int courseid){
		return ss.addStudentCourses(stdid, courseid);
	}
	 
	@PatchMapping("/update/{id}/student")
	@CrossOrigin
	public String updateStudentPartially(@PathVariable int id,@RequestBody Students student) {
		
		return ss.updateStudentPartially(id,student);
	}
	
}
