package com.te.resumebuilder.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.te.resumebuilder.util.ListToStringConverter;

import lombok.Data;

@Entity
@Data
public class Skills implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1354571476792107386L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer skillId;
	
	@Convert(converter = ListToStringConverter.class)
	private List<String> frontendTechnologies;
	
	@Convert(converter = ListToStringConverter.class)
	private List<String> backendTechnologies;
	
	@Convert(converter = ListToStringConverter.class)
	private List<String> middlewareTechnologies;

	@Convert(converter = ListToStringConverter.class)
	private List<String> designPatterns;

	@Convert(converter = ListToStringConverter.class)
	private List<String> databasesUsed;
	
	@Convert(converter = ListToStringConverter.class)
	private List<String> versionControlSystem;
	
	@Convert(converter = ListToStringConverter.class)
	private List<String> aws;
	
	@Convert(converter = ListToStringConverter.class)
	private List<String> sdlc;
	
	@Convert(converter = ListToStringConverter.class)
	private List<String> developmentTool;
	
}
