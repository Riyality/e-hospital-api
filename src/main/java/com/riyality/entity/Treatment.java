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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
@Table(name="treatment")
public class Treatment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="treatment_id")
	private int treatment_id;
	@Column(name="medicine_type")
	private String medicine_type;
	@Column(name="medicine")
	private String medicine;
	@Column(name="quantity")
	private int quantity;
	@Column(name="price")
	private int price;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="treatment_date")
	private LocalDate treatment_date;
	@Column(name="payment")
	private String payment;
	@ManyToOne
	@JoinColumn(name="admission",referencedColumnName = "admission_id")
private PatientAdmission admission;

}
