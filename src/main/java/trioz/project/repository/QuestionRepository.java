package trioz.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import trioz.project.domain.Question;
@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{
	@Query("SELECT q FROM Question q WHERE q.quize.quizeId =:quizId")
	public List<Question> getAllQuestionsByQuizId(@Param("quizId") Long quizId);
}
