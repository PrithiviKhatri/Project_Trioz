package trioz.project.domain;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private String name;
	private String description;
	private Set<Professor> professors = new HashSet<Professor>();
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
	public Set<Professor> getProfessors() {
		return professors;
	}
	public void setProfessors(Set<Professor> professors) {
		this.professors = professors;
	}
	public void addProfessor(Professor professor){
		professors.add(professor);
	}
	
	
}
