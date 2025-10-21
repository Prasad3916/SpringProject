package com.lms.application.controller;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.lms.application.model.Mentors;
import com.lms.application.service.MentorsService;

@RestController
@RequestMapping("/mentors")
public class MentorsController {

	@Autowired
	MentorsService ms;
	
	@RequestMapping("/")
	@CrossOrigin
	public List<Mentors> getMentors(){ 
		return ms.getMentors();
	}  
	 
	@RequestMapping("/{id}")
	@CrossOrigin
	public Mentors getMentorsById(@PathVariable int id) {
		return ms.getMentorsById(id);
	}
	
	@PostMapping("/addmentors")
	@CrossOrigin
	public String addMentors(@RequestPart Mentors mentor,
			@RequestPart MultipartFile profile) throws IOException {
		return ms.addMentors(mentor, profile);
	}
	
	@PutMapping("/updatementors")
	@CrossOrigin
	public String updateMentors(@RequestPart Mentors mentor,
			@RequestPart MultipartFile profile) throws IOException {
		return ms.updateMentors(mentor, profile);

	}
	 
	@RequestMapping("/profile/{id}")
	@CrossOrigin
	public ResponseEntity<?> getProfileById(@PathVariable int id){
			return ms.getProfileById(id);
	}
	 
	@RequestMapping("/ids")
	@CrossOrigin
	public List<Integer> getMentorsIds() { 
		return ms.getMentorsIds();
	}
	
	
	@RequestMapping("/mentee/{menteeid}/mentor/{mentorid}") 
	@CrossOrigin
	public String assignStudents(@PathVariable int menteeid,@PathVariable int mentorid) {
		
			return ms.assignStudents(menteeid, mentorid);
	}
	
	
	@PatchMapping("/update/{id}/mentor")
	@CrossOrigin
	public String updateMentorPartially(@PathVariable int id,@RequestBody Mentors mentor) {
		
		
		return ms.updateMentorPartially(id,mentor);
	}
	
	
	
}
