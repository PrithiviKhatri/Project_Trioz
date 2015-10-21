package trioz.project.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trioz.project.domain.Course;
import trioz.project.domain.Question;
import trioz.project.domain.Quize;
import trioz.project.repository.CourseRepository;
import trioz.project.repository.QuestionRepository;
import trioz.project.service.CourseService;
@Service
@Transactional
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private QuestionRepository questionRepository;
	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}
	@Override

	public List<Course> getAllCourses() {
		return (List<Course>)courseRepository.findAll();
	}
	@Override
	public Course getCourseById(Long courseId) {
		Course c = courseRepository.findOne(courseId);
		List<Quize> quizeList = c.getQuizeList();
		for(int i=0;i<quizeList.size();i++){
			Quize tmp = quizeList.get(i);
			List<Question> questionList = questionRepository.getAllQuestionsByQuizId(tmp.getQuizeId());
			List<String> questions = new ArrayList<>(questionList.size());
			for(Question q: questionList ){
				questions.add(q.getQuestion());
			}
			tmp.setQuestions(questions);
			quizeList.set(i, tmp);
		}
		return c;
	}

}
