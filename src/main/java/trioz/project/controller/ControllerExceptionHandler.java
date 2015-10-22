package trioz.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import trioz.project.exception.NoAssignmentsUnderCourseException;
import trioz.project.exception.NoCoursesUnderUserException;
import trioz.project.exception.NoUsersExistsException;

@ControllerAdvice
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
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No courses assigned to Professor")
	@ExceptionHandler(NoCoursesUnderUserException.class)
	public ModelAndView noCoursesUnderProfessor(HttpServletRequest req,  NoAssignmentsUnderCourseException ex){
		ModelAndView mav = new ModelAndView();
		mav.addObject("noCourses",ex.getFullMessage());
		mav.setViewName("coursesNotFoundUnderUser");
		return mav;
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No users exists in database")
	@ExceptionHandler(NoUsersExistsException.class)
	public String NoUsersExistsException(HttpServletRequest req,  NoUsersExistsException ex){
		ModelAndView mav = new ModelAndView();
		mav.addObject("noUsers",ex.getFullMessage());
		mav.setViewName("noUsersinDB");
		System.out.println("Here");
		return "noUsersinDB";
	}

}
