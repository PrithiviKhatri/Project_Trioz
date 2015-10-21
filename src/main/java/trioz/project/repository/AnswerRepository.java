package trioz.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import trioz.project.domain.Answer;
@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{

}
