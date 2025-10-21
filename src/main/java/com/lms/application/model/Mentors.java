package com.lms.application.model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
@Entity
public class Mentors {
//select name,bio,email,experience,linked_url,password,phone,profile_name,profile_type from mentors;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private String bio; 
	private int experience; 
	private String linkedUrl; 
	private String phone; 
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="mentor_id",referencedColumnName = "id")
	@JsonManagedReference
	private List<Courses> courses;
	private String profileName;
	private String profileType;
	private String status="pending"; 
	@Lob
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private byte[] profileFile;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="mentor_id",referencedColumnName = "id")
	private List<Students> students;
	public Mentors() {
		super();
	}
	public Mentors(int id, String name, String email, String password, String bio, int experience, String linkedUrl,
			String phone, List<Courses> courses, String profileName, String profileType, byte[] profileFile,
			List<Students> students) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.bio = bio;
		this.experience = experience;
		this.linkedUrl = linkedUrl;
		this.phone = phone;
		this.profileName = profileName;
		this.profileType = profileType;
		this.profileFile = profileFile;
	}
	
	
	public Mentors(String status) {
		super();
		this.status = status;
	}
	public List<Courses> getCourses() {
		return courses;
	}
	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
	public List<Students> getStudents() {
		return students;
	}
	public void setStudents(List<Students> students) {
		this.students = students;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getLinkedUrl() {
		return linkedUrl;
	}
	public void setLinkedUrl(String linkedUrl) {
		this.linkedUrl = linkedUrl;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
//	public List<Courses> getCourses() {
//		return courses;
//	}
//	public void setCourses(List<Courses> courses) {
//		this.courses = courses;
//	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getProfileType() {
		return profileType;
	}
	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}
	public byte[] getProfileFile() {
		return profileFile;
	}
	public void setProfileFile(byte[] profileFile) {
		this.profileFile = profileFile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Mentors [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", bio=" + bio
				+ ", experience=" + experience + ", linkedUrl=" + linkedUrl + ", phone=" + phone + ", courses="
				+ courses + ", profileName=" + profileName + ", profileType=" + profileType + ", status=" + status
				+ ", students=" + students + ", status="+status+"]";
	}
	
//	public List<Students> getStudents() {
//		return students;
//	}
//	public void setStudents(List<Students> students) {
//		this.students = students;
//	}
	
}
