package com.lms.application.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
@Entity
public class Courses {
// select category,description,language,level,time,title,video_name,video_type from courses;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;  
	private String description;
	private String category; 
	private String level;
	private String language;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date time; 
	private String videoName;
	private String videoType;
	@Lob
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private byte[] videoFile;
	@ManyToOne
	@JoinColumn(name = "mentor_id")
	@JsonBackReference
	private Mentors mentor; 
	@ManyToMany(mappedBy = "courses")
	private List<Students> students = new ArrayList<>();
	public Courses() { 
		super();
	}
	public Courses(int id, String title, String description, String category, String level, String language, Date time,
			String videoName, String videoType, byte[] videoFile) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.level = level;
		this.language = language; 
		this.time = time;
		this.videoName = videoName;
		this.videoType = videoType;
		this.videoFile = videoFile;
	}
	public void setStudents(List<Students> students) {
		this.students = students;
	}
	public Mentors getMentor() {
		return mentor;
	}
	public void setMentor(Mentors mentor) {
		this.mentor = mentor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoType() {
		return videoType;
	}
	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	public byte[] getVideoFile() {
		return videoFile;
	}
	public void setVideoFile(byte[] videoFile) {
		this.videoFile = videoFile;
	}
}
