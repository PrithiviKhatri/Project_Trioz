package trioz.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import trioz.project.domain.User;
import trioz.project.service.UserService;
import trioz.project.utility.SessionCheck;

@Controller
@SessionAttributes(value={"user","menuItems"})
public class LoginController {

	@Autowired
	UserService userservice;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(Model model) {
		System.out.println("inside login method!!!");
		return "login";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {
		System.out.println("inside welcome method");
		Map<String,String> menuItems;
		if (!SessionCheck.isUserExistsInSessionExists(model)) {
			System.out.println("inside session check");
			return "redirect:/logout";
		}
		User user = userservice.findUserByUserName(model.asMap().get("user").toString());
		System.out.println("user is " + user);
		model.addAttribute("user", user);
		switch (user.getRole()) {
		case "ROLE_ADMIN":
			menuItems = new HashMap<>();
			menuItems.put("Home", "/welcome");
			menuItems.put("Add User", "/user/addUser");
			menuItems.put("List User", "/user/listUsers");
			menuItems.put("List Professor", "/professor/displayListOfProfessor");
			menuItems.put("List Student", "/student/displayListOfStudents");
			menuItems.put("Add Course", "/course/add");
			menuItems.put("List Course", "/course");
			model.addAttribute("menuItems",menuItems);
			return "AdminHome";
		case "ROLE_PROFESSOR":
			menuItems = new HashMap<>();
			menuItems.put("Add Course", "/course/add");
			menuItems.put("List Course", "/course");
			model.addAttribute("menuItems",menuItems);
			return "ProfessorHome";
		case "ROLE_STUDENT":
			return "StudentHome";
		}
		return null; // need to change null to other page though dont see any
						// scenario where this even comes to this line
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model,SessionStatus status) {
		System.out.println("inside logout");
		status.setComplete();
		System.out.println("user is "+model.asMap().get("user"));
		return "redirect:/login";
	}

}
