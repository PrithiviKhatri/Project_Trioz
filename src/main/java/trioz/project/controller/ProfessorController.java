package trioz.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import trioz.project.domain.Assignment;
import trioz.project.service.AssignmentService;

@Controller
@RequestMapping({"/assignment"})
public class ProfessorController {
	@Autowired
	private AssignmentService assignmentService;
	@RequestMapping(value={"/add"},method = RequestMethod.GET)
	public String addAssignment(@ModelAttribute("newAssignment") Assignment assignment){
		return "addAssignment";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String saveAssignment(@ModelAttribute("newAssignment") Assignment assignment){
		assignmentService.save(assignment);
		return "addAssignment";
	}
}
