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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import trioz.project.domain.Course;
import trioz.project.domain.Student;
import trioz.project.service.CourseService;
import trioz.project.service.StudentService;

@Controller
@RequestMapping({"/course"})
@SessionAttributes({"course"})
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping(value={"","/list"},method = RequestMethod.GET)
	public String listCourse(Model model){
		List<Course> courses = courseService.getAllCourses();
		System.out.println("size:"+courses.size());
		model.addAttribute("courselist",courses);
		return "courseList";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String addCourseForm(@ModelAttribute("newCourse") Course course, Model model){
		return "addCourse";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveAssignment(@Valid @ModelAttribute("newCourse") Course course,
			BindingResult bindResult, RedirectAttributes redirectAttributes, Model model) {
		model.addAttribute("course",course);
		if (bindResult.hasErrors()) {
			return "addCourse";
		}
		courseService.save(course);
		redirectAttributes.addFlashAttribute("course", course);
		model.addAttribute("course", course);
		return "redirect:/course/show";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showAssignment(SessionStatus sessionStatus) {
//		sessionStatus.setComplete();
		return "course";

	}
	
	@RequestMapping(value = "/area", method = RequestMethod.GET)
	public String area(@RequestParam("courseId") Long courseId,Model model) {
		Course course = courseService.getCourseById(courseId);
		model.addAttribute("course",course);
		return "course";

	}
	
}
