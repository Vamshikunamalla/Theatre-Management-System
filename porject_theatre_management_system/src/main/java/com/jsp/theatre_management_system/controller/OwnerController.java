package com.jsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.theatre_management_system.dto.Owner;
import com.jsp.theatre_management_system.service.ownerSevice;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@RestController
public class OwnerController {

	@Autowired
	ownerSevice ownerSevice;
	
	@PostMapping("/saveOwner")
	public ResponseStructure<Owner> saveOwner(@RequestBody Owner owner) {
	return	ownerSevice.saveOwner(owner);
	}
	@GetMapping("/fetchOwnerById")
	public ResponseStructure<Owner> fetchOwnerById(@RequestParam int ownerId) {
		return	ownerSevice.fetchOwnerById(ownerId);
		}
	@DeleteMapping("/deleteOwnerById")
	public ResponseStructure<Owner> deleteOwnerById(@RequestParam int ownerId){
		return	ownerSevice.deleteOwnerById(ownerId);
		}
	@PutMapping("/updateOwnerById")
	public ResponseStructure<Owner> updateOwnerById(@RequestParam int oldOwnerId,@RequestBody Owner newOwner) {
		return	ownerSevice.updateOwnerById(oldOwnerId, newOwner)	;}
	@GetMapping("/fetchAllOwners")
	 public ResponseStructureList<Owner> fetchAllOwners(){
		 return ownerSevice.fetchAllOwners();
	 }
	
}
