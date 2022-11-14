package com.example.lms.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lms.entity.Admin;
import com.example.lms.repository.AdminRepository;
import com.example.lms.request.AdminDTO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public AdminDTO addAdmin(AdminDTO request) {
		
		Admin admin = new Admin();
		BeanUtils.copyProperties(request, admin);
		Admin save = adminRepository.save(admin);
		
		return AdminDTO.builder().adminId(save.getAdminId()).adminName(save.getAdminName()).accountBalance(save.getAccountBalance()).build();
		
	}

}
