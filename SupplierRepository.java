package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier, Long>{
	List<Supplier> findAll();
	Supplier findById(long id);
}
