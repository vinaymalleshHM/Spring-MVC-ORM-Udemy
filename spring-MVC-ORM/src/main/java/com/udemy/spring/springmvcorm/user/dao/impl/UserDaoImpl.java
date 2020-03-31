package com.udemy.spring.springmvcorm.user.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.udemy.spring.springmvcorm.user.dao.UserDao;
import com.udemy.spring.springmvcorm.user.entity.User;

import lombok.Data;

@Data
@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public int create(User user) {
		Integer result = (Integer) hibernateTemplate.save(user);
		return result;
	}

	@Override
	public List<User> findUsers() {
		return hibernateTemplate.loadAll(User.class);
	}

	@Override
	public User findUser(Integer id) {
		return hibernateTemplate.get(User.class, id);
	}

}
