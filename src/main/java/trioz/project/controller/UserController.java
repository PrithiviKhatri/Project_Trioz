package trioz.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import trioz.project.domain.User;
import trioz.project.exception.NoUsersExistsException;
import trioz.project.service.UserService;
import trioz.project.utility.SessionCheck;

@Controller

@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = ("/addUser"), method = RequestMethod.GET)
	public String addUser() {
		System.out.println("inside add User");
		return "addUser";

	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(User user, Model model) {
		System.out.println("inside save User");
		System.out.println("user is " + user);
		if (!SessionCheck.isUserExistsInSessionExists(model)) {
			System.out.println("inside session check");
			return "redirect:/logout";
		}
		userService.saveUser(user);
		model.addAttribute("Message", "Below User has been successfully saved!!");
		return "UserDetails";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/deleteUser/{userId}")
	public String deleteUserbyId(@PathVariable("userId") Long userid, Model model) {
		System.out.println("inside delete User");
		if (!SessionCheck.isUserExistsInSessionExists(model)) {
			System.out.println("inside session check");
			return "redirect:/logout";
		}
		User user = userService.findUserById(userid);

		userService.deleteUserById(userid);
		;
		model.addAttribute("Message", "Below User has been successfully deleted!!");
		model.addAttribute("user", user);
		return "UserDetails";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	public String findAllUsers(Model model) {
		System.out.println("inside find all users");
		if (!SessionCheck.isUserExistsInSessionExists(model)) {
			System.out.println("inside session check");
			return "redirect:/logout";
		}
		List<User> users = userService.findAllUsers();
		
		if (users.isEmpty())
			throw new NoUsersExistsException();

		model.addAttribute("users", users);
		return "ListUsers";
	}


}


