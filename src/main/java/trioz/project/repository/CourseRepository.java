package trioz.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import trioz.project.domain.Course;
import trioz.project.domain.User;
@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{
	
	/*@Query(value = "select  c from Course c where c.courseId = :courseId")
	public List<User> findAllCoursesByProfessorId(@Param("courseId") long courseId);
 */

}
