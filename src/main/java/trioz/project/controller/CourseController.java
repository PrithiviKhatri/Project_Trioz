package trioz.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import trioz.project.domain.Course;
import trioz.project.service.CourseService;

@Controller
@RequestMapping({"/course"})
public class CourseController {
	@Autowired
	private CourseService courseService;
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String addCourseForm(@ModelAttribute("newCourse") Course course, Model model){
		return "addCourse";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveAssignment(@Valid @ModelAttribute("newCourse") Course course,
			BindingResult bindResult, RedirectAttributes redirectAttributes, Model model) {
		System.out.println("here");
		model.addAttribute(course);
		if (bindResult.hasErrors()) {
			System.out.println("Size:" + bindResult.getErrorCount());
			return "addCourse";
		}
		courseService.save(course);
		redirectAttributes.addFlashAttribute("course", course);
		model.addAttribute("course", course);
		return "redirect:/course/show";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showAssignment(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "course";

	}
}
