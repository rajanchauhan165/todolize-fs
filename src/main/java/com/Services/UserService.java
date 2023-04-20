package com.Services;
import java.util.List;

import com.Entities.Tasks;
import com.Entities.User;
import com.Exceptions.UserException;

public interface UserService {
	User createUser(User user);
	Tasks createTask(String email, Tasks task) throws UserException;
	User deleteUser(String email, String password) throws UserException;
	Tasks deleteTask(int taskId);
	List<User> getAllUser();
}
