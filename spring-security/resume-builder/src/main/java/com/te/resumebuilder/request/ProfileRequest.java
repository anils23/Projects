package com.te.resumebuilder.request;

import java.util.List;

import com.te.resumebuilder.entity.Education;
import com.te.resumebuilder.entity.ProjectDetails;
import com.te.resumebuilder.entity.Skills;

import lombok.Data;

@Data
public class ProfileRequest {
	
	private String employeeId;
	
	private String resumeId;

	private String firstName;

	private String lastName;

	private String technology;

	private String totalExperience;

	private String relevantExperience;

	private List<String> summary;

	private Skills skills;

	private Education education;
	
	private List<ProjectDetails> projectDetails;

}
