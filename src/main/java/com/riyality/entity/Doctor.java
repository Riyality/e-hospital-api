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

@Entity
@Table( name = "doctors" )
@Setter
@Getter
public class Doctor {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;

	@Column( name = "first_name" )
	private String firstName;

	@Column( name = "last_name" )
	private String lastName;

	@Column( name = "specialization" )
	private String specialization;

	@Column( name = "email" )
	private String email;

	@Column( name = "phone_number" )
	private String phoneNumber;

	@Column( name = "address" )
	private String address;

	@Column( name = "experience" )
	private String experience;

	@Column( name = "status" )
	private String status;

	@ManyToOne
	@JoinColumn( name = "branch" )
	private Branch branch;

	@Column( name = "consultation_fee" )
	private Integer consultationFee;

	@Column( name = "available_days" )
	private String availableDays;

	@Column( name = "available_time_slots" )
	private String availableTimeSlots;

	@Column( name = "joining_date" )
	private LocalDate joiningDate;

	@Column( name = "qualifications" )
	private String qualifications;
}
