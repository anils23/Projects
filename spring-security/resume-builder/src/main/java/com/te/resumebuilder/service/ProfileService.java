package com.te.resumebuilder.service;

import java.util.List;

import com.te.resumebuilder.entity.Profile;
import com.te.resumebuilder.request.ProfileRequest;

public interface ProfileService {

	Profile addResumes(ProfileRequest request);

	List<String> getResumeByEmployeeId(String employeeId);

	Profile getResumeByResumeIdAndEmployeeId(String resumeId, String employeeId);
	
	Profile updateResumeByResumeIdAndEmployeeId(ProfileRequest request);

}
