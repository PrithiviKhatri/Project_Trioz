package trioz.project.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long courseId;

//	@NotEmpty
//	@Size(min=5,max=20,message="Size")
	private String name;
	private String description;
	//private Set<Professor> professors = new HashSet<Professor>();
	@JoinColumn(name = "courseId")
	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Assignment> assignments = new HashSet<Assignment>();

	@JoinColumn(name = "courseId")
	@ManyToMany
	private List<Student> students = new ArrayList<Student>();
	
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	//	public Set<Professor> getProfessors() {
	//		return professors;
	//	}
	//	public void setProfessors(Set<Professor> professors) {
	//		this.professors = professors;
	//	}
	//	public void addProfessor(Professor professor){
	//		professors.add(professor);
	//	}
	public Set<Assignment> getAssignments() {
		return assignments;
	}
	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	public void addAssignments(Assignment assignment){
		this.assignments.add(assignment);
	}


}
