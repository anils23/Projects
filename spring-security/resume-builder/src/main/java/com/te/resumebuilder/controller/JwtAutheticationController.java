package com.te.resumebuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.resumebuilder.config.JwtTokensUtil;
import com.te.resumebuilder.config.JwtUsersDetailService;
import com.te.resumebuilder.entity.JwtRequest;
import com.te.resumebuilder.entity.JwtResponse;
import com.te.resumebuilder.request.UserRequest;
import com.te.resumebuilder.service.UserServiceImpl;

@RestController
@CrossOrigin
public class JwtAutheticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokensUtil jwtTokenUtil;

	@Autowired
	private JwtUsersDetailService userDetailsService;
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> saveUsers(@RequestBody UserRequest request){
		return ResponseEntity.ok(userServiceImpl.saveUser(request));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

	}
}
