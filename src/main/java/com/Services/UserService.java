package com.Services;
import java.util.List;

import org.springframework.security.core.Authentication;

import com.Entities.Tasks;
import com.Entities.User;
import com.Exceptions.UserException;

public interface UserService {
	public String registerUser(User user)throws UserException;
}
