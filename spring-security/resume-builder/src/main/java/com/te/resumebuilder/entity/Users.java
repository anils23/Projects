package com.te.resumebuilder.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Users implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2071472248453609969L;

	@Id
	private int userId;
	
	private String username;
	
	private String password;

}
