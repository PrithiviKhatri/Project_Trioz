package trioz.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import trioz.project.domain.Course;
@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{

}
