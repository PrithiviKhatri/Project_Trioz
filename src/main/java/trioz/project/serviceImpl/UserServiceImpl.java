package trioz.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public User saveUser(User user) {

		return userRepo.save(user);
	}

	public void deleteUser(User user) {
		userRepo.delete(user);

	}

	public List<User> findAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public void deleteUserById(Long userid) {
		userRepo.delete(userid);
	}

	@Override
	public User findUserById(Long id) {
		return userRepo.findOne(id);
	}

	

}
