package com.ab.service;

import java.util.ArrayList;
import java.util.List;

import com.ab.model.User;

public class UserService {
	
	private List<User> users = null;

	public UserService() {
		super();
		
		this.users = new ArrayList<User>();
		
		this.users.add(new User("Bogdan","24"));
		this.users.add(new User("Adi","24"));
		this.users.add(new User("Grigore","24"));

	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	
	
	
}
