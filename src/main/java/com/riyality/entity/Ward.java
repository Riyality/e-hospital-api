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
@Table( name = "ward" )
public class Ward {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "ward_id" )
	private Long id;

	@Column( name = "ward_name", nullable = false )
	private String wardName;

	@Column( name = "max_capacity", nullable = false )
	private int maxCapacity;

	@Column( name = "current_occupancy", nullable = false )
	private int currentOccupancy;

	@Column( name = "floor_number", nullable = false )
	private int floorNumber;

	@Column( name = "wing", nullable = false )
	private String wing;

	@Column( name = "status", nullable = false )
	private String status;

	@ManyToOne
	@JoinColumn( name = "branch" )
	private Branch branch;

	@Column( name = "charges", nullable = false )
	private int charges;

}
