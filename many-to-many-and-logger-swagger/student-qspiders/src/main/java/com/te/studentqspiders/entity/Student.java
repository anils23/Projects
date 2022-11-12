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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_details")
@JsonInclude(value = Include.NON_DEFAULT)
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6906398680755047482L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;

	private String studentName;

	@ManyToMany(mappedBy = "student",cascade = {CascadeType.PERSIST,CascadeType.DETACH})
	private List<Qspiders> qspiders;

}
