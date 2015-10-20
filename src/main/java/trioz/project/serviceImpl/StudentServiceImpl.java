package trioz.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trioz.project.domain.Course;
import trioz.project.domain.Student;
import trioz.project.repository.StudentRepository;
import trioz.project.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	@Override
	public List<Student> getAll() {
		return (List<Student>) studentRepository.findAll();
	}
	
	@Override
	public Student getStudentById(Long studentId) {
		return studentRepository.findOne(studentId);
	}
}
