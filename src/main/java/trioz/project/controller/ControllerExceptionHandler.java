package trioz.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import trioz.project.exception.NoAssignmentsUnderCourseException;

//@ControllerAdvice
public class ControllerExceptionHandler {
	public static final String DEFAULT_ERROR_VIEW = "error";
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No assignments found")
	@ExceptionHandler(NoAssignmentsUnderCourseException.class)
	public ModelAndView noAssignments(HttpServletRequest req, NoAssignmentsUnderCourseException ex){
		ModelAndView mav = new ModelAndView();
		mav.addObject("noAssignment",ex.getFullMessage());
		mav.setViewName("assignmentNotFound");
		return mav;
	}
	
	
}
