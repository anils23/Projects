package com.te.resumebuilder.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.resumebuilder.entity.Users;
import com.te.resumebuilder.repository.UserRepository;

@Service
public class JwtUsersDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users users = userRepository.findByUsername(username);
		
		if (users != null) {
			return new User(users.getUsername(),users.getPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	

}