package trioz.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trioz.project.domain.Course;
import trioz.project.repository.CourseRepository;
import trioz.project.service.CourseService;
@Service
@Transactional
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseRepository courseRepository;
	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}
	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return (List<Course>)courseRepository.findAll();
	}

}
