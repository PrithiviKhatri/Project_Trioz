package trioz.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import trioz.project.domain.Quize;
@Repository
public interface QuizeRepository extends CrudRepository<Quize, Long> {
	
}
