package com.lms.application.model;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Students {
// select name,profile_name,profile_type,phone_number,password,email,gender,address,date_of_birth,qualification from students;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String qualification;
	private String email;
	private String password;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private String phoneNumber;
	private String address;
	private String gender;
	private String profileType;
	private String profileName;
	private String status="pending";
	@Lob
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
	private byte[] profileFile;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "mentor_id")
	@JsonIgnoreProperties("students")
	private Mentors mentor;
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(
	    name = "student_courses",
	    joinColumns = @JoinColumn(name = "student_id"),
	    inverseJoinColumns = @JoinColumn(name = "course_id")
	)
	private List<Courses> courses;
	public Students() {
		super();
	}
	public Students( String name, String qualification, String email, String password, Date dateOfBirth,
			String phoneNumber, String address, String gender, String profileType, String profileName,
			byte[] profileFile) {
		super();
		this.name = name;
		this.qualification = qualification;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.gender = gender;
		this.profileType = profileType;
		this.profileName = profileName;
		this.profileFile = profileFile;
	}
	
	public Students(String status) {
		super();
		this.status = status;
	}
	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
	public List<Courses> getCourses() {
		return courses;
	}
	public void setMentor(Mentors mentor) {
		this.mentor = mentor;
	}
	public Mentors getMentor() {
		return mentor;
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
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfileType() {
		return profileType;
	}
	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
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
		return "Students [id=" + id + ", name=" + name + ", qualification=" + qualification + ", email=" + email
				+ ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", gender=" + gender + ", profileType=" + profileType + ", profileName="
				+ profileName + ", status="+	status+"]";
	}
}
