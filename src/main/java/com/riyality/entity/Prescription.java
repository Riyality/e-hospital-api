package com.riyality.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "prescriptions" )
public class Prescription {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "prescription_id" )
	private Long prescriptionId;

	@ManyToOne
	@JoinColumn( name = "patient_id", nullable = false )
	private Patient patient;

	@ManyToOne
	@JoinColumn( name = "doctor_id", nullable = false )
	private Doctor doctor;

	@Column( name = "prescription_date", nullable = false )
	private LocalDate prescriptionDate;

	@Column( columnDefinition = "TEXT" )
	private String prescription;

}
