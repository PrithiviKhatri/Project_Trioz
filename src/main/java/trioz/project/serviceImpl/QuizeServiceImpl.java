package trioz.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trioz.project.domain.Question;
import trioz.project.domain.Quize;
import trioz.project.repository.QuestionRepository;
import trioz.project.repository.QuizeRepository;
import trioz.project.service.QuizeService;
@Service
@Transactional
public class QuizeServiceImpl implements QuizeService{
	@Autowired
	private QuizeRepository quizeRepository;
	@Autowired
	private QuestionRepository questionRepository;
	@Override
	public Quize save(Quize quize) {
		Quize q = quizeRepository.save(quize);
		List<String> questions = quize.getQuestion();
		for(String question:questions){
			Question quest = new Question();
			quest.setQuestion(question);
			quest.setQuize(quize);
			questionRepository.save(quest);
		}
		return q;
	}

}
