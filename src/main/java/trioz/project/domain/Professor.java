package trioz.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long professorId;
	private User user;
	private String academicQualification;
	private String experience;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAcademicQualification() {
		return academicQualification;
	}
	public void setAcademicQualification(String academicQualification) {
		this.academicQualification = academicQualification;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
}
