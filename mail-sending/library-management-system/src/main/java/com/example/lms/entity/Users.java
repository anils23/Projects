package com.example.lms.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -35683651098161303L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	private String userName;
	
	private Double accountBalance;
	
	private String emailId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private List<Books> books;

	
}
