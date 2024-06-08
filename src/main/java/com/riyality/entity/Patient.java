package com.riyality.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table( name = "patients" )
public class Patient {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "patient_id" )
	private Long id;

	@Column( name = "first_name" )
	private String firstName;

	@Column( name = "last_name" )
	private String lastName;

	private String gender;

	@Column( name = "date_of_birth" )
	private LocalDate dateOfBirth;

	private String address;

	@Column( name = "phone_number" )
	private String phoneNumber;

	private String email;

	@Column( name = "emergency_contact_name" )
	private String emergencyContactName;

	@Column( name = "emergency_contact_number" )
	private String emergencyContactNumber;

	@Column( name = "blood_type" )
	private String bloodType;

	private String allergies;

	@Column( name = "medical_history" )
	private String medicalHistory;

	private String occupation;

	@Column( name = "marital_status" )
	private String maritalStatus;

	private String nationality;

	@Column( name = "language_spoken" )
	private String languageSpoken;

	private String religion;

	@ManyToOne
	@JoinColumn( name = "insurance_id", referencedColumnName = "insurance_id" )
	private InsuranceDetail insuranceDetail;

	@ManyToOne
	@JoinColumn( name = "branch" )
	private Branch branch;

	@ManyToOne
	@JoinColumn( name = "doctor_id", nullable = true )
	private Doctor doctor;

	@Column( name = "admission_status" )
	private String admissionStatus;
}
