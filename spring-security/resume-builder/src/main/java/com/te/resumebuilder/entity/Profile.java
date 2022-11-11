package com.te.resumebuilder.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.te.resumebuilder.util.ListToStringConverter;

import lombok.Data;

@Entity
@Data
public class Profile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1534759556714370210L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer profileId;
	
	private String resumeId;
	
	private String employeeId;

	private String firstName;
	
	private String lastName;
	
	private String technology;
	
	private String totalExperience;
	
	private String relevantExperience;
	
	@Convert(converter = ListToStringConverter.class)
	private List<String> summary;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Skills skills;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Education education;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "profileId")
	private List<ProjectDetails> projectDetails;
	
	
	
}
