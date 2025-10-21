package com.lms.application.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.lms.application.model.Courses;
import com.lms.application.model.Students;
import com.lms.application.repository.CourseRepo;
import com.lms.application.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo sr; 
	
	@Autowired
	CourseRepo cr;
	
	public List<Students> getStudents(){ 
		return sr.findAll();
	} 
	
	public Students getStudentById(int id) {
		Students student = sr.findById(id).orElse(null);
		if(student!=null) {
			return student;
		}
		return new Students();
	}
	
	public String addStudent( Students student,
			 MultipartFile profile) throws IOException {
		student.setProfileName(profile.getOriginalFilename());
		student.setProfileType(profile.getContentType());
		student.setProfileFile(profile.getBytes());
		sr.save(student);
		return "Uploaded Sucessfully"; 
	}
	
	public String updateStudent( Students student,
			 MultipartFile profile) throws IOException {
		student.setProfileName(profile.getOriginalFilename());
		student.setProfileType(profile.getContentType());
		student.setProfileFile(profile.getBytes());
		sr.save(student);
		return "Uploaded Sucessfully";
	}
	
	public ResponseEntity<?> getProfileById(int id){
		Students student=sr.findById(id).orElse(null);
		if(student!=null) {
			byte[] profile=student.getProfileFile();
			return ResponseEntity.ok()
					.contentType(MediaType.valueOf(student.getProfileType()))
					.body(profile);
		}
		return new ResponseEntity<>("failed",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public List<Integer> getStudentIds() {
		List<Students> students = getStudents();
		List<Integer> list = students.stream().map(e->e.getId()).toList();
		return list;
	}
	
	 
	public String addStudentCourses(int stdid,int courseid){
	    Students stud = sr.findById(stdid).orElse(null);
	    Courses course = cr.findById(courseid).orElse(null);

	    if (stud == null || course == null) {
	        return "Student or Course not found";
	    }

	    if (stud.getCourses() == null) {
	        stud.setCourses(new ArrayList<>());
	    }

	    stud.getCourses().add(course);
	    sr.save(stud); // Persist the change

	    System.out.println("Hello World");
	    return "Course purchased successfully by student";

	}

	public String updateStudentPartially(int id,Students student) {
		
		Students s=getStudentById(id);
		System.out.println(student.getStatus());
		s.setStatus(student.getStatus());
		System.out.println(s.getStatus());
		System.out.println(s);
		sr.save(s);
		return "Updated";
	}
	 
	
	
	
	
}
