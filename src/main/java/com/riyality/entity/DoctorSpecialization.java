package com.riyality.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table( name = "doctor_specialization" )
public class DoctorSpecialization {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;

	@Column( name = "title" )
	private String title;

}
