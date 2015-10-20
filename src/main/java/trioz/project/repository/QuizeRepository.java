package trioz.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import trioz.project.domain.Quize;
@Repository
public interface QuizeRepository extends CrudRepository<Quize, Long> {

}
