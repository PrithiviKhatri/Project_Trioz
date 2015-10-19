package trioz.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import trioz.project.domain.Assignment;

@Repository
public interface AssignmentRepository extends CrudRepository<Assignment,Long>{

	
}
