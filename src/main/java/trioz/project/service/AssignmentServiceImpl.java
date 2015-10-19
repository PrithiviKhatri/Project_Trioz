package trioz.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trioz.project.domain.Assignment;
import trioz.project.repository.AssignmentRepository;
@Service
@Transactional
public class AssignmentServiceImpl implements AssignmentService{

	@Autowired
	private AssignmentRepository assignmentRepository;
	
	@Override
	public Assignment save(Assignment assignment) {
		return assignmentRepository.save(assignment);
	}

}
