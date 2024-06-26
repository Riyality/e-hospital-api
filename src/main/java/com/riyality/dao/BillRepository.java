package com.riyality.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riyality.entity.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {
}
