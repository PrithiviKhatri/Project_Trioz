package trioz.project.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import trioz.project.domain.Course;
import trioz.project.service.CourseService;
import trioz.project.service.UserService;;

public class CustomFormBinder extends CustomCollectionEditor {

	CourseService courseservice;

	public CustomFormBinder(CourseService cservice, final Class collectionType) {
		super(collectionType, true);
		courseservice = cservice;
	}

	@Override
	protected Object convertElement(final Object element) {
		try {
			System.out.println("inside convertElement of CustomFormbinder");
			Course course = courseservice.getCourseById(Long.valueOf(element.toString()));
			return course;

		} catch (NumberFormatException e) {
			System.out.println("Unable to convert " + element + " to long");
			return null;
		}
	}

}
