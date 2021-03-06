package trioz.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import trioz.project.domain.Course;
import trioz.project.domain.Quize;
import trioz.project.service.QuizeService;
import trioz.project.utility.SessionCheck;

@Controller
@RequestMapping({ "/quiz" })
@SessionAttributes({ "user", "course" })
public class QuizController {
	@Autowired
	private QuizeService quizeService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showAddQuestionForm(@ModelAttribute("newQuiz") Quize quiz, Model model) {
		if (!SessionCheck.isUserExistsInSessionExists(model)) {
			System.out.println("inside session check");
			return "redirect:/logout";
		}
		return "addQuiz";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveQuiz(@ModelAttribute("newQuiz") Quize quize, Model model) {
		if (!SessionCheck.isUserExistsInSessionExists(model)) {
			System.out.println("inside session check");
			return "redirect:/logout";
		}
		Course c = (Course) model.asMap().get("course");
		quize.setCourse(c);
		Quize q = quizeService.save(quize);

		return "quize";
	}
}
