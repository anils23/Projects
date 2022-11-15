package com.tyss.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Superheroes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5379650263430551954L;
	@Id
	private Integer id;
	
	private String name;
	
	private String realName;

}
