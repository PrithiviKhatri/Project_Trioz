package trioz.project.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import trioz.project.domain.User;

public interface UserService {

	public User saveUser(User user);

	public User findUserById(Long id);

	public void deleteUserById(Long userid);

	public List<User> findAllUsers();

	public void deleteUser(User user);

	public List<User> findAllProfessors(String role);

	public User findUserByUserName(String username);

}

