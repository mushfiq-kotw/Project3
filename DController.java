package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Distributor")
public class DController {
	@Autowired
	private DistributorRepository distributorRepository;
	
	@GetMapping("AddDistributor")
	public String addDistributor(@RequestBody Distributor distributor)
	{	distributorRepository.save(distributor);
		return "Distributor has been added successfully.";
	}
	@GetMapping("fetchAllDistributors")
	public ResponseEntity<List<Distributor>> fetchAllDistributors()
	{	return ResponseEntity.ok(distributorRepository.findAll());
	}
	@GetMapping("updateDistributorDetails")
	public String updateDistributorDetails(@RequestBody DistributorDetails distDet)
	{	Distributor distributor = distributorRepository.findById(distDet.getDistributorId());
		distributor.setName(distDet.getName());
		distributor.setLocation(distDet.getLocation());
		distributor.setPhoneNo(distDet.getPhoneNo());
		distributorRepository.save(distributor);
		return "Distributor details updated successfully.";
	}
}
