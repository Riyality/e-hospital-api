package com.riyality.dao;

import org.springframework.data.repository.CrudRepository;

import com.riyality.entity.Patient;

public interface ReportsRepository extends CrudRepository<Patient, Long>  {

}
