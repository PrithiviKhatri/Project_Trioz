package trioz.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import trioz.project.domain.Question;
@Repository
public interface QuestionRepository extends CrudRepository<Question, Long>{

}
