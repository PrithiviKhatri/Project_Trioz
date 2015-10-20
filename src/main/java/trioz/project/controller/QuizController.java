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

@Controller
@RequestMapping({"/quiz"})
@SessionAttributes({"course"})
public class QuizController {
	@Autowired
	private QuizeService quizeService;
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String showAddQuestionForm(@ModelAttribute("newQuiz") Quize quiz){
		return "addQuiz";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String saveQuiz(@ModelAttribute("newQuiz") Quize quize,Model model){
		System.out.println("Descriptions:"+quize.getDescription());
		List<String> quest = quize.getQuestion();
		System.out.println("Quest Size:"+quest.size());
		Course c = (Course) model.asMap().get("course");
		System.out.println("Name:"+c.getName());
		for(String s:quest){
			System.out.println(s);
		}
		quize.setCourse(c);
		Quize q = quizeService.save(quize);
		
		System.out.println("quizeId:"+q.getQuizeId());
		return "quize";
	}
}
