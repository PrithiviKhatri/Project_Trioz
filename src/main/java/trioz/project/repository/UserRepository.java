package trioz.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import trioz.project.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query(value = "select u from User u where u.role = :role")
	public List<User> findAllProfessors(@Param("role") String role);

	@Query(value = "select u from User u where u.userName = :username")
	public User findUserByUserName(@Param("username") String username);

}
