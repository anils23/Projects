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
public class Books implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2719854378049470823L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	private Boolean bookAvailibility;
	
	private String bookName;
	
	private String authorName;
	
	private String bookDescription;
	
	private Double costPerHour;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookId")
	private List<Users> users;
	
}
