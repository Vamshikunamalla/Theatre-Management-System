package com.jsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.theatre_management_system.dao.OwnerDao;
import com.jsp.theatre_management_system.dto.Owner;
import com.jsp.theatre_management_system.exception.OwnerIdNotFound;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@Service
public class ownerSevice {
	@Autowired
	OwnerDao ownerDao;
	@Autowired
	ResponseStructure<Owner> responseStructure;
	@Autowired
	ResponseStructureList<Owner> responseStructureList;
	public ResponseStructure<Owner> saveOwner(Owner owner) {
		responseStructure.setStatusCoad(HttpStatus.CREATED.value());
    	responseStructure.setMessage("Succesfully Owner saved  the  into db");
    	responseStructure.setData(ownerDao.saveOwner(owner));
	return responseStructure	;
	}

	public ResponseStructure<Owner> fetchOwnerById(int ownerId) {
		Owner owner=ownerDao.fetchOwnerById(ownerId);
		if(owner!=null) {
		responseStructure.setStatusCoad(HttpStatus.FOUND.value());
    	responseStructure.setMessage("Succesfully fetchOwnerById  the  into db");
    	responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
	return responseStructure;}
		else {
			throw new OwnerIdNotFound();
		}
	}
	public ResponseStructure<Owner> deleteOwnerById(int ownerId){
		Owner owner=ownerDao.fetchOwnerById(ownerId);
		if(owner!=null) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
    	responseStructure.setMessage("Succesfully deleteOwnerById  the  into db");
    	responseStructure.setData(ownerDao.deleteOwnerById(ownerId));
	return responseStructure;}
		else {
			throw new OwnerIdNotFound();
		}
	}
	
	public ResponseStructure<Owner> updateOwnerById(int oldOwnerId,Owner newOwner) {
		Owner owner=ownerDao.fetchOwnerById(oldOwnerId);
		if(owner!=null) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
    	responseStructure.setMessage("Succesfully updateOwnerById the  into db");
    	responseStructure.setData(ownerDao.saveOwner(newOwner));
	return responseStructure;}
		else {
			throw new OwnerIdNotFound();
		}
	}
	 public ResponseStructureList<Owner> fetchAllOwners(){
		 Owner owner=(Owner) ownerDao.fetchAllOwners();
			if(owner!=null) {
		 responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		 responseStructureList.setMessage("Succesfully fetchAllOwners from  db");
		 responseStructureList.setData(ownerDao.fetchAllOwners());
		 return responseStructureList;}
			else {
				throw new OwnerIdNotFound();
			}
	 }

}
