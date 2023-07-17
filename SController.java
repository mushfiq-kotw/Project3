package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Supplier")
public class SController {
	@Autowired
	private SupplierRepository supplierRepository;
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@GetMapping("AddSupplier")
	public String addSupplier(@RequestBody Supplier supplier)
	{	supplierRepository.save(supplier);
		return "Supplier has been added successfully";
	}
	@GetMapping("fetchAllSuppliers")
	public ResponseEntity<List<Supplier>> fetchAllSuppliers()
	{	return ResponseEntity.ok(supplierRepository.findAll());
	}
	@GetMapping("updateSupplierDetails")
	public String updateSupDetails(@RequestBody SupplierDetails supplierDetails)
	{	Supplier supplier =  supplierRepository.findById(supplierDetails.getSupplierId());
		supplier.setName(supplierDetails.getName());
		supplier.setLocation(supplierDetails.getLocation());
		supplier.setPhoneNo(supplierDetails.getPhoneNo());
		supplierRepository.save(supplier);
		return "Supplier Details updated successfully";
	}
	@GetMapping("AddWarehouse")
	public String addWarehouse(@RequestBody Warehouse warehouse)
	{	warehouseRepository.save(warehouse);
		return "Warehouse added successfully.";
	}
	@GetMapping("FetchWarehouse")
	public ResponseEntity<Warehouse> fetchWarehouse(@RequestBody Warehouseno warehouseno)
	{	Optional<Warehouse> fetchedWare = warehouseRepository.findById(warehouseno.getWarehouseId());
		if(fetchedWare.isPresent())
			return ResponseEntity.ok(fetchedWare.get()); 
		else
			return ResponseEntity.badRequest().build();
	}

}
