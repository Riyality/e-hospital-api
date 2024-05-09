package com.riyality.entity;

import java.time.LocalDateTime;

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
@Table( name = "insurance_details" )
public class InsuranceDetail {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name = "insurance_id" )
	private Long id;

	@Column( name = "policy_number" )
	private String policyNumber;

	@Column( name = "provider_name" )
	private String providerName;

	@Column( name = "expiry_date" )
	private LocalDateTime expiryDate;

}
