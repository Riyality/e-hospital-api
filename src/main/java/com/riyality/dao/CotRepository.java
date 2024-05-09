package com.riyality.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.riyality.entity.Cot;
import com.riyality.entity.Ward;

public interface CotRepository extends CrudRepository<Cot, Long> {

	List<Cot> findByWardAndStatus( Ward ward, String string );

	List<Cot> findByWard( Ward ward );
}
