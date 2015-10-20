package trioz.project.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Quize {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long quizeId;
	@Transient
	private List<String> question = new ArrayList<>();
public Long getQuizeId() {
		return quizeId;
	}
	public void setQuizeId(Long quizeId) {
		this.quizeId = quizeId;
	}
	public List<String> getQuestion() {
		return question;
	}
	public void setQuestions(List<String> question) {
		this.question = question;
	}
	//	private List<String> answers;
	private String grade;
	private String description;
	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
//	public List<String> getAnswers() {
//		return answers;
//	}
//	public void setAnswers(List<String> answers) {
//		this.answers = answers;
//	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
