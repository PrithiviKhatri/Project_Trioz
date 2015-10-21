package trioz.project.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import trioz.project.domain.Course;
import trioz.project.domain.User;
import trioz.project.formatter.CustomFormBinder;
import trioz.project.repository.UserRepository;
import trioz.project.service.CourseService;
import trioz.project.service.UserService;

@Controller
@RequestMapping("/professor")
@SessionAttributes("user")
public class ProfessorController {

	@Autowired
	UserRepository userrepository;
	@Autowired
	UserService userservice;
	@Autowired
	CourseService courseservice;

	@InitBinder
	public void bindForm(final WebDataBinder binder) {
		binder.registerCustomEditor(Set.class, "professor.courses", new CustomFormBinder(courseservice, Set.class));

	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String showProfessorHome(User user, Model model) {
		User professor = userrepository.findUserByUserName(user.getUserName());
		model.addAttribute("user", professor);
		return "ProfessorHome";

	}

	@RequestMapping(value = ("/displayListOfProfessor"), method = RequestMethod.GET)
	public String listProfessors(Model model) {
		System.out.println("inside list of Professor");
		List<User> users = userrepository.findAllProfessors("ROLE_PROFESSOR");
		model.addAttribute("users", users);
		return "ListOfProfessors";

	}

	@RequestMapping(value = ("/editProfessorByAdmin/{userId}"), method = RequestMethod.GET)
	public String editProfessorByAdmin(@PathVariable("userId") Long userId, Model model) {
		System.out.println("inside edit Professor By Admin");
		User user = userservice.findUserById(userId);
		model.addAttribute("editProfessor", user);

		return "editProfessorByAdmin";

	}

	@RequestMapping(value = ("/editProfessorByAdmin"), method = RequestMethod.POST)
	public String saveProfessorByAdmin(@ModelAttribute("editProfessor") User user, Model model) {
		System.out.println("inside save Professor By Admin");

		User professor = userrepository.findOne(user.getUserId());
		professor.setFirstName(user.getFirstName());
		professor.setLastName(user.getLastName());
		professor.setProfessor(user.getProfessor());

		userservice.saveUser(professor);
		model.addAttribute("message", "Updated successfully");
		model.addAttribute("user", professor);
		return "ProfessorDetails";
	}

	@ModelAttribute("courses")
	public List<Course> getAllCourses() {
		return courseservice.getAllCourses();
	}

}
