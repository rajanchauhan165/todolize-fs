package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
