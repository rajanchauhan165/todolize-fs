package com.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Tasks {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer taskId;
	@NotNull
	private String title;
	@NotNull
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;

	//constructors
	public Tasks() {
	}
	
	public Tasks(Integer taskId, @NotNull String title, @NotNull String description, User user) {
		this.taskId = taskId;
		this.title = title;
		this.description = description;
		this.user = user;
	}

	//getterSetter
	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
