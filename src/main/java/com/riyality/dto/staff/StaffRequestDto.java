package com.riyality.dto.staff;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StaffRequestDto {
	private Long id;
	@NotNull
    @Size(max = 32)
	private String firstName;
	@NotNull
    @Size(max = 32)
	private String lastName;
	@NotNull
    @Size(max = 32)
	private String role;
	 @Size(max = 64)
	private String email;
	 @NotNull
	 @Size(max = 10,min=10)
	private String phoneNumber;
	 @Size(max = 256)
	private String address;
	 @Size(max = 16)
	private String experience;
	 @Size(max = 32)
	private String status;
	private int branch;

}
