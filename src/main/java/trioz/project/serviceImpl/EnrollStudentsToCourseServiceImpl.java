package trioz.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trioz.project.domain.Course;
import trioz.project.domain.Student;
import trioz.project.repository.CourseRepository;
import trioz.project.service.EnrollStudentsToCourseService;

@Service
@Transactional
public class EnrollStudentsToCourseServiceImpl implements EnrollStudentsToCourseService{

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		
	}

/*	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public void save(Student student) {
		return courseRepository.save(course);
		
	}*/
}
