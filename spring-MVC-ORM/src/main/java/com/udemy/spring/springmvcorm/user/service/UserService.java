package com.udemy.spring.springmvcorm.user.service;

import java.util.List;

import com.udemy.spring.springmvcorm.user.entity.User;

public interface UserService {
	int save(User user);
	List<User> getUsers();
	User getUser(Integer id);
}
