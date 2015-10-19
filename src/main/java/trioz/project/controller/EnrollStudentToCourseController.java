package trioz.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import trioz.project.domain.Course;
import trioz.project.domain.Student;
import trioz.project.service.CourseService;
import trioz.project.service.StudentService;

@Controller
@RequestMapping({"/enroll"})
public class EnrollStudentToCourseController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

	@ModelAttribute("courses")
	List<Course> addCourseList(Model model) {

		return  courseService.getAll();

	}

	@ModelAttribute("students")
	List<Student> addStudentList(Model model) {

		return  studentService.getAll();

	}

	@RequestMapping(value="/enrollStudent",method=RequestMethod.GET)
	public String enrollStudentToCourse(@ModelAttribute("newEnroll") Course course, Model model){		
		return "enrollStudent";
	}

	@RequestMapping(value="/enrollStudent",method=RequestMethod.POST)
	public String saveSelection(@Valid @ModelAttribute("newEnroll") Course course,
			BindingResult result,Model model){
		if(result.hasErrors()){
			return "enrollStudent";
		}

		courseService.save(course);
		return "redirect:/enroll/enrollDetails";
	}

	@RequestMapping(value = "/enrollDetails", method = RequestMethod.GET)
	public String showEnrollment(SessionStatus sessionStatus) {
		return "listOfStudents";

	}

}
