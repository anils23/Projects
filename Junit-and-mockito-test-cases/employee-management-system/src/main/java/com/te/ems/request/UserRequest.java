package com.te.ems.request;

import java.util.List;

import com.te.ems.entity.Roles;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {

	private int userId;

	private String userName;

	private String password;

	private Roles role;

}
