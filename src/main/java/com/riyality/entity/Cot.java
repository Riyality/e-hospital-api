package com.riyality.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "cot" )
public class Cot {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "cot_id" )
	private Long cotId;

	@Column( name = "cot_number", nullable = false )
	private int cotNumber;

	@ManyToOne
	@JoinColumn( name = "ward_id", nullable = false )
	private Ward ward;

	@Column( name = "status", nullable = false )
	private String status;

	@OneToOne
	@JoinColumn( name = "patient_id", unique = true )
	private Patient patient;

}
