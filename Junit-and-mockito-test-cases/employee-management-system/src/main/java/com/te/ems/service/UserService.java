package com.te.ems.service;

import com.te.ems.entity.User;
import com.te.ems.request.UserRequest;

public interface UserService {

	User addUser(UserRequest request);

}
