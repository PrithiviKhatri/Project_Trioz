package trioz.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import trioz.project.domain.Assignment;
import trioz.project.service.AssignmentService;

@Controller
@RequestMapping({"/assignment"})
public class AssignmentController {
	@Autowired
	private AssignmentService assignmentService;
	@RequestMapping(value={"/add"},method = RequestMethod.GET)
	public String addAssignment(@ModelAttribute("newAssignment") Assignment assignment,Model model){
		return "addAssignment";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public String saveAssignment(@Valid @ModelAttribute("newAssignment") Assignment assignment,
			RedirectAttributes redirectAttributes,
			Model model,
			BindingResult bindResult){
		System.out.println("here");
		model.addAttribute(assignment);
		if(bindResult.hasErrors()){
			System.out.println("Size:"+bindResult.getErrorCount());
			return "addAssignment";
		}
		assignmentService.save(assignment);
		redirectAttributes.addFlashAttribute("assignment", assignment);
		model.addAttribute("assignment", assignment);
		return "redirect:/assignment/show";
	}
	
	@RequestMapping(value="/show", method = RequestMethod.GET)
	public String showAssignment(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "assignment";
		
	}
}
