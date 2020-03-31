package com.udemy.spring.springmvcorm.user.entity;

import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User implements Comparable<User>{
	@Id
	private Integer id;
	private String name;
	private String email;
	@Override
	public int compareTo(User user) {
		return this.id.compareTo(user.id);
	}
}
