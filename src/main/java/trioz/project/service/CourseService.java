package trioz.project.service;

import java.util.List;

import trioz.project.domain.Course;

public interface CourseService {
	public Course save(Course course);

	public List<Course> getAllCourses();
	public Course getCourseById(Long courseId);

}
