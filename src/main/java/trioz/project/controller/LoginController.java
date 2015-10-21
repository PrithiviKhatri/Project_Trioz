package trioz.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import trioz.project.domain.User;
import trioz.project.service.UserService;

@Controller
@SessionAttributes("user")
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

		User user = userservice.findUserByUserName(model.asMap().get("user").toString());
		System.out.println("user is " + user);
		model.addAttribute("user", user);
		switch (user.getRole()) {
		case "ROLE_ADMIN":
			return "AdminHome";
		case "ROLE_PROFESSOR":
			return "ProfessorHome";
		case "ROLE_STUDENT":
			return "StudentHome";
		}
		return null; // need to change null to other page though dont see any scenario where this even comes to this line
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus status) {
		status.setComplete();
		return "redirect:/login";
	}

}
