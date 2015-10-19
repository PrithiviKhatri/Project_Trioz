package trioz.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trioz.project.domain.Assignment;
import trioz.project.repository.AssignmentRepository;
import trioz.project.service.AssignmentService;
@Service
@Transactional
public class AssignmentServiceImpl implements AssignmentService{

	@Autowired
	private AssignmentRepository assignmentRepository;
	
	@Override
	public Assignment save(Assignment assignment) {
		return assignmentRepository.save(assignment);
	}

	@Override
	public void deleteAssignment(Long assignmentId) {
		assignmentRepository.delete(assignmentId);;
	}

	@Override
	public Assignment updateAssignment(Assignment assignment) {
		return assignmentRepository.save(assignment);
	}

	@Override
	public Assignment getAssignmentById(Long assignmentId) {
		return assignmentRepository.findOne(assignmentId);
	}

}
