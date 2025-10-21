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

import com.lms.application.model.Mentors;
import com.lms.application.model.Students;
import com.lms.application.repository.MentorRepo;
import com.lms.application.repository.StudentRepo;

@Service
public class MentorsService {

	@Autowired
	MentorRepo mr; 
	
	@Autowired
	StudentRepo sr;
	
	public List<Mentors> getMentors(){ 
		return mr.findAll();
	} 
	
	public Mentors getMentorsById(int id) {
		Mentors Mentors = mr.findById(id).orElse(null);
		if(Mentors!=null) {
			return Mentors;
		}
		return new Mentors();
	}
	
	public String addMentors( Mentors mentor,
			 MultipartFile profile) throws IOException {
		mentor.setProfileName(profile.getOriginalFilename());
		mentor.setProfileType(profile.getContentType());
		mentor.setProfileFile(profile.getBytes());
		mr.save(mentor);
		return "Uploaded Sucessfully"; 
	}
	
	public String updateMentors( Mentors mentor,
			 MultipartFile profile) throws IOException {
		mentor.setProfileName(profile.getOriginalFilename());
		mentor.setProfileType(profile.getContentType());
		mentor.setProfileFile(profile.getBytes());
		mr.save(mentor);
		return "Uploaded Sucessfully";
	}
	
	public ResponseEntity<?> getProfileById(int id){
		Mentors mentor=mr.findById(id).orElse(null);
		if(mentor!=null) {
			byte[] profile=mentor.getProfileFile();
			return ResponseEntity.ok()
					.contentType(MediaType.valueOf(mentor.getProfileType()))
					.body(profile);
		}
		return new ResponseEntity<>("failed",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public List<Integer> getMentorsIds() {
		List<Mentors> mentor = getMentors();
		List<Integer> list = mentor.stream().map(e->e.getId()).toList();
		return list;
	}
	 
	
	
	public String assignStudents(int menteeid,int mentorid) {
		
		Students stud=sr.findById(menteeid).orElse(null);
		
		Mentors mentor=mr.findById(mentorid).orElse(null);
		if(mentor.getStudents()!=null) {
			mentor.getStudents().add(stud);
		}
		else {
			mentor.setStudents(new ArrayList<>());
			mentor.getStudents().add(stud);
		}
		mr.save(mentor);
		return "Assigned Successfully";
	}

	public String updateMentorPartially(int id, Mentors mentor) {
		Mentors s=getMentorsById(id);
		s.setStatus(mentor.getStatus());
		System.out.println(s.getStatus());
		System.out.println(s);
		mr.save(s);
		return "Updated";	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
