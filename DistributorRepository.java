package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DistributorRepository extends CrudRepository<Distributor, Long>{
	List<Distributor> findAll();
	Distributor findById(long id);

}
