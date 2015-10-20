package trioz.project.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import trioz.project.domain.Course;
import trioz.project.domain.Student;
import trioz.project.formatter.StudentFormBinder;
import trioz.project.service.CourseService;
import trioz.project.service.StudentService;

@Controller
@RequestMapping({"/enroll"})
public class EnrollStudentToCourseController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;
	
	 @InitBinder
	   public void bindForm(final WebDataBinder binder)
	   {
	   		 binder.registerCustomEditor(Set.class, "students",  new StudentFormBinder(studentService, Set.class));
	   }

	@ModelAttribute("courses")
	List<Course> addCourseList(Model model) {

		return  courseService.getAllCourses();

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
	public String saveSelection(@ModelAttribute("newEnroll") Course course,
			Model model,RedirectAttributes redirectAttributes){
	
		Course addStudentToThisCourse = courseService.getCourseById(course.getCourseId());
		addStudentToThisCourse.setStudents(course.getStudents());
		System.out.println(addStudentToThisCourse.getName() +"-----"+addStudentToThisCourse.getCourseId());
		
		System.out.println("I'm a astudent"+addStudentToThisCourse.getStudents());
//		
//		model.addAttribute("message", "Updated successfully");
//		model.addAttribute("courseInfo", addStudentToThisCourse);
		redirectAttributes.addFlashAttribute("message", "Updated successfully");
		redirectAttributes.addFlashAttribute("courseInfo", addStudentToThisCourse);

		courseService.save(addStudentToThisCourse);
		return "redirect:/enroll/enrollDetails";
	}

	@RequestMapping(value = "/enrollDetails", method = RequestMethod.GET)
	public String showEnrollment(SessionStatus sessionStatus) {
		return "listOfStudentsInCourse";

	}

}
