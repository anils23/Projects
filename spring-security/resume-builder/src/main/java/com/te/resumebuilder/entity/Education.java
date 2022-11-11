package com.te.resumebuilder.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Education implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6575496478059691054L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer educationId;
	
	private String highestEducation;
	
	private String specialization;
	
	private String university;
	
	private Integer passOutYear;
	
	private Double percentage;
}
