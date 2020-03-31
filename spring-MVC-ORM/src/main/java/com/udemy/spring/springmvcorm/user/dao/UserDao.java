package com.udemy.spring.springmvcorm.user.dao;

import java.util.List;

import com.udemy.spring.springmvcorm.user.entity.User;

public interface UserDao {
	int create(User user);
	List<User> findUsers();
	User findUser(Integer id);
	
}
