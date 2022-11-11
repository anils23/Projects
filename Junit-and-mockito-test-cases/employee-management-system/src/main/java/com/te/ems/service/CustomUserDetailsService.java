package com.te.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.ems.entity.User;
import com.te.ems.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		CustomUserDetails customUserDetails = null;
		if (user != null) {
            customUserDetails = new CustomUserDetails();
            customUserDetails.setUser(user);
		}else {
			throw new UsernameNotFoundException("Sorry no user found");
		}
		return customUserDetails;
	}

}
