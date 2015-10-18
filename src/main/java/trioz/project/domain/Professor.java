package trioz.project.domain;

public class Professor {
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
