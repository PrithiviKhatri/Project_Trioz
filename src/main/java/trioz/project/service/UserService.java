package trioz.project.service;

import java.util.List;

import trioz.project.domain.User;

public interface UserService {

	public User saveUser(User user);

	public User UserfindUserById(Long id);

	public void deleteUserById(Long userid);

	public List<User> findAllUsers();

	public void deleteUser(User user);

	//public List<User> findAllProfessors();

}
