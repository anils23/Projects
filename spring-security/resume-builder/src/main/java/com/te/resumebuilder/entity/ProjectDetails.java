package com.te.resumebuilder.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.te.resumebuilder.util.ListToStringConverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2649157140359640398L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projectId;

	@Convert(converter = ListToStringConverter.class)
	private List<String> frontendTechnologies;

	@Convert(converter = ListToStringConverter.class)
	private List<String> backendTechnologies;

	@Convert(converter = ListToStringConverter.class)
	private List<String> designPatterns;

	@Convert(converter = ListToStringConverter.class)
	private List<String> databasesUsed;
	
	@Convert(converter = ListToStringConverter.class)
	private List<String> developmentTool;
	
	private String duration;
	
	private Integer teamSize;
	
	@Lob
	private String projectDescription;

	@Lob
	private String rolesAndResponsibailities;
		
}
