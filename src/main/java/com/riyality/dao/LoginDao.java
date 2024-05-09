package com.riyality.dao;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.riyality.entity.Login;

public interface LoginDao extends CrudRepository<Login, Integer> {

	Login findByUsername(String username);

	@Modifying
	@Transactional
	@Query("UPDATE Login l SET l.role=:role WHERE l.username=:username")
	void updateStatus(@Param("role") String role,@Param("username") String username);
}
