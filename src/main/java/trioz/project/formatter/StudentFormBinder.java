package trioz.project.formatter;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import trioz.project.domain.Course;
import trioz.project.domain.Student;
import trioz.project.service.CourseService;
import trioz.project.service.StudentService;

public class StudentFormBinder extends CustomCollectionEditor {

	StudentService studentService;

	public StudentFormBinder(StudentService studentService, final Class collectionType) {
		super(collectionType, true);
		this.studentService = studentService;
	}

	@Override
	protected Object convertElement(final Object element) {
		try {
			System.out.println("inside convertElement of StudentFormbinder");
			Student student = studentService.getStudentById(Long.valueOf(element.toString()));
			return student;

		} catch (NumberFormatException e) {
			System.out.println("Unable to convert " + element + " to long");
			return null;
		}
	}

}
