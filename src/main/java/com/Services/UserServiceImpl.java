package com.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Entities.Tasks;
import com.Entities.User;
import com.Exceptions.UserException;
import com.Repository.TaskRepo;
import com.Repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private TaskRepo taskRepo;

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public Tasks createTask(String email, Tasks task) throws UserException {
		Optional<User> extUser = userRepo.findByEmail(email);
		if(extUser.isPresent()) {
			task.setUser(extUser.get());
			return taskRepo.save(task);
		}
		else {
			throw new UserException("User not found with email "+email);
		}
	}

	@Override
	public User deleteUser(String email, String password) throws UserException {
		Optional<User> extUser = userRepo.findByEmail(email);
		if(extUser.isPresent()) {
			if(extUser.get().getPassword().equals(password)) {
				userRepo.delete(extUser.get());
				return extUser.get();
			}
			else {
				throw new UserException("Wrong Password");
			}
		}
		else {
			throw new UserException("User do not exist");
		}
	}

	@Override
	public Tasks deleteTask(int taskId) {
		Optional<Tasks> tasks = taskRepo.findById(taskId);
		taskRepo.delete(tasks.get());
		return tasks.get();
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

}
