package com.udemy.spring.springmvcorm.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udemy.spring.springmvcorm.user.entity.User;
import com.udemy.spring.springmvcorm.user.service.UserService;

import lombok.Data;

@Data
@Controller
public class UserController {

	@Autowired
	private UserService service;


	@RequestMapping("registrationPage")
	public String showRegistrationPage() {
		return "userReg";

	}

	@RequestMapping(value = "registerUser" , method = RequestMethod.POST)
	public String rigisterUser(@ModelAttribute("user") User user , ModelMap modelMap) {
		int result = service.save(user);
		modelMap.addAttribute("result", "User Created With Id " + result);
		return "userReg";

	}

	@RequestMapping("getUsers")
	public String getUser(ModelMap modelMap) {
		List<User> users = service.getUsers();
		modelMap.addAttribute("users", users);
		return "displayUsers";

	}

	@RequestMapping("validateEmail")
	public @ResponseBody String validateEmail(@RequestParam ("id") int id) {
		User user = service.getUser(id);
		String msg = "";
		if (user!=null) {
			msg = id + "Already Exist";
		}
		return msg;
	}

}
