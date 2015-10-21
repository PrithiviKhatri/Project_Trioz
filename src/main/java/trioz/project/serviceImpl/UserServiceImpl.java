package trioz.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trioz.project.domain.User;
import trioz.project.repository.UserRepository;
import trioz.project.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User saveUser(User user) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepo.save(user);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteUser(User user) {
		userRepo.delete(user);

	}

	public List<User> findAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteUserById(Long userid) {
		userRepo.delete(userid);
	}

	@Override
	public User findUserById(Long id) {
		return userRepo.findOne(id);
	}

	@Override
	public List<User> findAllProfessors(String role) {
		return userRepo.findAllProfessors(role);
	}

	@Override
	public User findUserByUserName(String username) {

		return userRepo.findUserByUserName(username);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public User updateUser(User user) {
		return userRepo.save(user);
	}

}
