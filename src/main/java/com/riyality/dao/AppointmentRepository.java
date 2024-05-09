package com.riyality.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.riyality.entity.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

	@Query( "SELECT a FROM Appointment a WHERE DATE(a.appointmentDate) = :today" )
	List<Appointment> findTodayAppointments( @Param( "today" ) Date today );

	@Query( "SELECT a FROM Appointment a WHERE DATE(a.appointmentDate) = :today AND a.doctor.id = :doctorId" )
	List<Appointment> findTodayAppointmentsForDoctor( @Param( "today" ) Date today, @Param( "doctorId" ) Long doctorId );

}