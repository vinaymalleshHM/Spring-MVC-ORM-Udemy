package com.udemy.spring.springmvcorm.user.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.spring.springmvcorm.user.dao.UserDao;
import com.udemy.spring.springmvcorm.user.entity.User;
import com.udemy.spring.springmvcorm.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;


	@Override
	@Transactional
	public int save(User user) {
		// Business Logic
		return dao.create(user);
	}


	@Override
	public List<User> getUsers() {
		List<User> users = dao.findUsers();
		Collections.sort(users);
		return users ;
	}


	@Override
	public User getUser(Integer id) {
		return dao.findUser(id);
	}

}
