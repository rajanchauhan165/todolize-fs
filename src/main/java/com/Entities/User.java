package com.Entities;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@NotNull
	private String name;
	@Email
	private String email;
	@Size(min = 3,max = 32)
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	List<Tasks> tasks = new ArrayList<>();
	
	//constructors
	public User() {
	}
	
	public User(Integer userId, @NotNull String name, @Email String email, @Size(min = 3, max = 32) String password, List<Tasks> tasks) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.tasks = tasks;
	}

	//getterSetters
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Tasks> getTasks() {
		return tasks;
	}

	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}
	
	
}
