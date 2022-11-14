package com.example.lms.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Notifications implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7071686058286086225L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer notificationId;
	
	private String message;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Admin admin;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Users users;

}
