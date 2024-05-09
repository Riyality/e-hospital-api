package com.riyality.entity;

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
@Table( name = "medicines" )
public class Medicine {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "medicine_id" )
	private Long medicineId;

	@ManyToOne
	@JoinColumn( name = "prescription_id", nullable = false )
	private Prescription prescription;

	@Column( name = "medicine_name", nullable = false )
	private String medicineName;

	@Column( name = "medicine_type" )
	private String medicineType;

	private String dosage;

	@Column( columnDefinition = "TEXT" )
	private String instructions;

	@Column( name = "num_days" )
	private Integer numDays;

	@Column( name = "tablet_quantity" )
	private Integer tabletQuantity;

}
