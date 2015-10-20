package trioz.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import trioz.project.domain.User;
import trioz.project.service.UserService;

@Controller

@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = ("/addUser"), method = RequestMethod.GET)
	public String addUser() {
		System.out.println("inside add User");
		return "addUser";


	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(User user, Model model) {
		System.out.println("inside save User");
		System.out.println("user is " + user);
		userService.saveUser(user);
		model.addAttribute("Message", "Below User has been successfully saved!!");
		return "UserDetails";
	}

	@RequestMapping(value = "/deleteUser/{userId}")
	public String deleteUserbyId(@PathVariable("userId") Long userid, Model model) {
		System.out.println("inside delete User");

		User user = userService.findUserById(userid);

		userService.deleteUserById(userid);
		;
		model.addAttribute("Message", "Below User has been successfully deleted!!");
		model.addAttribute("user", user);
		return "UserDetails";
	}

	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	public String findAllUsers(Model model) {
		System.out.println("inside find all users");
		List<User> users = userService.findAllUsers();
		System.out.println("users size " + users.size());
		model.addAttribute("users", users);
		return "ListUsers";
	}

}
