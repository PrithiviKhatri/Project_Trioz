package trioz.project.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

import trioz.project.domain.Course;
import trioz.project.domain.Professor;
import trioz.project.domain.User;
import trioz.project.formatter.CustomFormBinder;
import trioz.project.service.CourseService;
import trioz.project.service.UserService;
import trioz.project.utility.SessionCheck;

@Controller
@RequestMapping("/professor")
@SessionAttributes("user")
public class ProfessorController {

	/*
	 * @Autowired UserRepository userrepository;
	 */
	@Autowired
	UserService userservice;
	@Autowired
	CourseService courseservice;

	@InitBinder
	public void bindForm(final WebDataBinder binder) {
		binder.registerCustomEditor(Set.class, "professor.courses", new CustomFormBinder(courseservice, Set.class));

	}

	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String showProfessorHome(User user, Model model) {
		if (!SessionCheck.isUserExistsInSessionExists(model)) {
			System.out.println("inside session check");
			return "redirect:/logout";
		}
		User professor = userservice.findUserByUserName(user.getUserName());
		model.addAttribute("user", professor);
		return "ProfessorHome";

	}

	@RequestMapping(value = ("/displayListOfProfessor"), method = RequestMethod.GET)
	public String listProfessors(Model model) {
		System.out.println("inside list of Professor");
		if (!SessionCheck.isUserExistsInSessionExists(model)) {
			System.out.println("inside session check");
			return "redirect:/logout";
		}

		List<User> users = userservice.findAllProfessors("ROLE_PROFESSOR");
		model.addAttribute("users", users);
		return "ListOfProfessors";

	}

	@RequestMapping(value = ("/editProfessorByAdmin/{userId}"), method = RequestMethod.GET)
	public String editProfessorByAdmin(@PathVariable("userId") Long userId, Model model) {
		if (!SessionCheck.isUserExistsInSessionExists(model)) {
			System.out.println("inside session check");
			return "redirect:/logout";
		}
		System.out.println("inside edit Professor By Admin");
		User user = userservice.findUserById(userId);
		model.addAttribute("editProfessor", user);

		return "editProfessorByAdmin";

	}

	@PreAuthorize("hasRole('ROLE_PROFESSOR)")
	@RequestMapping(value = ("/editProfessorByAdmin"), method = RequestMethod.POST)
	public String saveProfessorByAdmin(@ModelAttribute("editProfessor") User user, Model model) {
		System.out.println("inside save Professor By Admin");
		if (!SessionCheck.isUserExistsInSessionExists(model)) {
			System.out.println("inside session check");
			return "redirect:/logout";
		}
		// User professor = userrepository.findOne(user.getUserId());
		User professor = userservice.findUserById(user.getUserId());
		System.out.println("user is " + professor);
		professor.setFirstName(user.getFirstName());
		professor.setLastName(user.getLastName());
		professor.setProfessor(user.getProfessor());

		userservice.updateUser(professor);
		model.addAttribute("message", "Updated successfully");
		model.addAttribute("user", professor);
		return "ProfessorDetails";
	}


	/*@RequestMapping(value = ("/saveProfile"), method = RequestMethod.POST)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public User saveProfile(@RequestBody User usertobeupdated, Model model) {
		System.out.println("inside save Professor Profile");
		
		User user = userservice.findUserById(usertobeupdated.getUserId());
		System.out.println("user is " + user);
		user.getProfessor().setAcademicQualification(usertobeupdated.getProfessor().getAcademicQualification());
		user.getProfessor().setExperience(usertobeupdated.getProfessor().getExperience());
		userservice.saveUser(user);
		return user;
	}
*/
	@ModelAttribute("courses")
	public List<Course> getAllCourses() {
		return courseservice.getAllCourses();
	}

}
