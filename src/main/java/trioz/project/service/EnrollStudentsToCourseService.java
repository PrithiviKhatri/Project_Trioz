package trioz.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trioz.project.domain.Course;
import trioz.project.domain.Student;

@Service
@Transactional
public interface EnrollStudentsToCourseService {

	public void save(Student student);


}
