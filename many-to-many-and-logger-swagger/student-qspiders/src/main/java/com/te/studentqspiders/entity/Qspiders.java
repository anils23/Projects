package com.te.studentqspiders.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "qspiders_details")
@Builder
@JsonInclude(value = Include.NON_DEFAULT)
public class Qspiders implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8814029458012693826L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer qspidersId;

	private String qspidersBranch;

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.DETACH})
	private List<Student> student;
	

}
