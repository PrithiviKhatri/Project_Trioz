package trioz.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import trioz.project.domain.Assignment;

@Controller
@RequestMapping({"/assignment"})
public class ProfessorController {
	@RequestMapping(value={"/add"},method = RequestMethod.GET)
	public String addAssignment(@ModelAttribute("newAssignment") Assignment assignment){
		
		return "addAssignment";
	}
}
