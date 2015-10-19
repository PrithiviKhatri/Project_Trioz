package trioz.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import trioz.project.domain.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student,Long>{

	
}
