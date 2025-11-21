package com.jsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.theatre_management_system.Repo.OwnerRepo;
import com.jsp.theatre_management_system.dto.Owner;
@Repository
public  class OwnerDao {

	@Autowired
	OwnerRepo ownerRepo;
	
	public Owner saveOwner(Owner owner) {	
    return	ownerRepo.save(owner);
	}
	
	public Owner fetchOwnerById(int ownerId) {
		Optional<Owner> owner=ownerRepo.findById(ownerId);
		if(owner.isPresent()) {
			return owner.get();
		}else {
			return null;
		}
	}
	public Owner deleteOwnerById(int ownerId){
	Owner owner=ownerRepo.findById(ownerId).get();
	ownerRepo.delete(owner);
		return owner;
	}
	
	public Owner updateOwnerById(int oldOwnerId,Owner newOwner) {
	newOwner.setOwnerId(oldOwnerId);
    return	ownerRepo.save(newOwner);
	}
		
   public List<Owner> fetchAllOwners(){
	return   ownerRepo.findAll();
	
}

	

	
}
