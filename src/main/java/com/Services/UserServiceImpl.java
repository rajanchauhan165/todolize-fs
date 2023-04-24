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
	public String registerUser(User user) throws UserException {
		userRepo.save(user);
		return "reg";
	}

	

}
