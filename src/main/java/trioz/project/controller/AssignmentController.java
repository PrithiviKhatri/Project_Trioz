package trioz.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import trioz.project.domain.Assignment;
import trioz.project.domain.Course;
import trioz.project.service.AssignmentService;
import trioz.project.service.CourseService;
import trioz.project.utility.SessionCheck;

@Controller
@RequestMapping({ "/assignment" })
@SessionAttributes({ "user", "course" })
public class AssignmentController {
	@Autowired
	private AssignmentService assignmentService;
	@Autowired
	CourseService courseService;

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public String addAssignment(@ModelAttribute("newAssignment") Assignment assignment, Model model) {
		if (!SessionCheck.isUserExistsInSessionExists(model)) {
			System.out.println("inside session check");
			return "redirect:/logout";
		}
		return "addAssignment";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveAssignment(@Valid @ModelAttribute("newAssignment") Assignment assignment,
			BindingResult bindResult, RedirectAttributes redirectAttributes, Model model) {
		if (!SessionCheck.isUserExistsInSessionExists(model)) {
			System.out.println("inside session check");
			return "redirect:/logout";
		}
		model.addAttribute(assignment);
		if (bindResult.hasErrors()) {
			return "addAssignment";
		}
		Course course = (Course) model.asMap().get("course");
		course.addAssignments(assignment);
		courseService.save(course);
		redirectAttributes.addFlashAttribute("assignment", assignment);
		model.addAttribute("assignment", assignment);
		return "redirect:/assignment/show";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showAssignment(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "assignment";

	}

	@RequestMapping(value = "/delete/{courseId}/{assignmentId}", method = RequestMethod.GET)
	public String showAssignment(@PathVariable("courseId") Long courseId,
			@PathVariable("assignmentId") Long assignmentId, Model model) {
		if (!SessionCheck.isUserExistsInSessionExists(model)) {
			System.out.println("inside session check");
			return "redirect:/logout";
		}
		assignmentService.deleteAssignment(assignmentId);
		return "redirect:/course/area?courseId=" + courseId;
	}

	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	@RequestMapping(value = "/edit/{assignmentId}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("assignmentId") Long assignmentId, Model model) {
		if (!SessionCheck.isUserExistsInSessionExists(model)) {
			System.out.println("inside session check");
			return "redirect:/logout";
		}
		Assignment toBeUpdated = assignmentService.getAssignmentById(assignmentId);
		model.addAttribute("updateAssignment", toBeUpdated);
		System.out.println("toBeUpdated-id:" + toBeUpdated.getAssignmentId());
		return "editAssignment";
	}

	@PreAuthorize("hasRole('ROLE_PROFESSOR')")
	@RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
	public String updateAssignment(@ModelAttribute("updateAssignment") Assignment assignment, Model model) {
		if (!SessionCheck.isUserExistsInSessionExists(model)) {
			System.out.println("inside session check");
			return "redirect:/logout";
		}
		System.out.println("id:" + assignment.getAssignmentId());
		assignmentService.save(assignment);
		return "assignment";
	}
}
