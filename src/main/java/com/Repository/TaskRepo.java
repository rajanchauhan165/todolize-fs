package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entities.Tasks;

public interface TaskRepo extends JpaRepository<Tasks, Integer>{

}
