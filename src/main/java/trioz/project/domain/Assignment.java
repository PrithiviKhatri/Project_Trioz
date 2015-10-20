package trioz.project.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Assignment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long assignmentId;
	@NotEmpty
	@Size(min=2,max=15,message="{Size}")
	private String title;
	private String description;
	private String Answer;
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date assignDate;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date dueDate;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date submissionDate;
	public Long getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
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
	public Date getAssignDate() {
		return assignDate;
	}
	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}
}
