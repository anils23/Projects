package com.example.lms.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lms.entity.Users;
import com.example.lms.repository.UserRespository;
import com.example.lms.request.UsersDTO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRespository userRespository;

	@Override
	public UsersDTO addUsers(UsersDTO request) {

		Users users = new Users();
		BeanUtils.copyProperties(request, users);
		Users save = userRespository.save(users);
		
		return UsersDTO.builder().userId(save.getUserId()).userName(save.getUserName()).accountBalance(save.getAccountBalance()).emailId(save.getEmailId()).build();
	}

}
