package trioz.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import trioz.project.domain.User;
import trioz.project.repository.UserRepository;
import trioz.project.service.CourseService;
import trioz.project.service.UserService;

@Controller
@RequestMapping("/student")
@SessionAttributes("user")
public class StudentController {


	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String showStudentHome(User user, Model model) {
		User student = userRepository.findUserByUserName(user.getUserName());
		model.addAttribute("user", student);
		return "StudentHome";

	}
	
	@RequestMapping(value = ("/displayListOfStudents"), method = RequestMethod.GET)
	public String listStudents(Model model) {
		List<User> users = userRepository.findAllUserByRole("ROLE_STUDENT");
		model.addAttribute("users", users);
		return "ListOfStudents";

	}

	@RequestMapping(value = ("/editStudentByAdmin/{userId}"), method = RequestMethod.GET)
	public String editStudentByAdmin(@PathVariable("userId") Long userId, Model model) {
		User user = userService.findUserById(userId);
		model.addAttribute("editStudent", user);

		return "editStudentByAdmin";

	}

	@RequestMapping(value = ("/editStudentByAdmin"), method = RequestMethod.POST)
	public String saveStudentByAdmin(@ModelAttribute("editStudent") User user, Model model) {

		User student = userRepository.findOne(user.getUserId());
		student.setStudent(user.getStudent());
		
		System.out.println("THIS IS A STUDENT"+student.getStudent());

		userService.saveUser(student);
		model.addAttribute("message", "Updated successfully");
		model.addAttribute("user", student);
		return "StudentDetails";
	}

}
