package com.spti.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spti.entity.Cot;
import com.spti.entity.Ward;

public interface CotRepository extends CrudRepository<Cot, Long> {

	List<Cot> findByWardAndStatus( Ward ward, String string );

	List<Cot> findByWard( Ward ward );
}
