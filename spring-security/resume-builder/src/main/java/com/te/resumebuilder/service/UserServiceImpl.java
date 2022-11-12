package com.te.resumebuilder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.resumebuilder.entity.Users;
import com.te.resumebuilder.repository.UserRepository;
import com.te.resumebuilder.request.UserRequest;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;

//	as its a interface and we need the bean of this interface.
//	we will create a bean of its child class in WebSecurityconfig and autowire it.
	@Autowired
	private PasswordEncoder passwordEncoder;

// this API will store the user details in database

	public Users saveUser(UserRequest user) {
		Users newUser = new Users();
		newUser.setUsername(user.getUsername());

// before storing the password we need to encode the password and then save.
// for encoding we take help of inbuilt interface called PasswordEncoder.
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		return userRepository.save(newUser);
	}

}
