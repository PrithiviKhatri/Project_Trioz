package trioz.project.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import trioz.project.domain.Course;
import trioz.project.domain.Student;
import trioz.project.service.CourseService;
import trioz.project.service.StudentService;

public class StudentFormatter implements Formatter<Student> {

	@Autowired
	StudentService studentService;

	@Override
	public String print(Student object, Locale locale) {
	System.out.println("inside print of CourseFormatter");
		return object.getStudentId().toString();
	}

	@Override
	public Student parse(String source, Locale locale) throws ParseException {
		System.out.println("inside parse of Course Formatter");
		Student student = studentService.getStudentById(Long.valueOf(source));
		return student;
	}

}
