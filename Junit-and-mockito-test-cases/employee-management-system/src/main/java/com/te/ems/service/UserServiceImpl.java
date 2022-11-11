package com.te.ems.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.ems.entity.User;
import com.te.ems.repository.UserRepository;
import com.te.ems.request.UserRequest;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public User addUser(UserRequest request) {
		
		User user = new User();
		BeanUtils.copyProperties(request, user);
		user.setPassword(encoder.encode(request.getPassword()));
		
		return userRepository.save(user);
	}

}
