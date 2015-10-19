package trioz.project.service;

import trioz.project.domain.Assignment;

public interface AssignmentService {
	public Assignment save(Assignment assignment);
	public void deleteAssignment(Long assignmentId);
	public Assignment updateAssignment(Assignment assignment);
	public Assignment getAssignmentById(Long assignmentId);
}
