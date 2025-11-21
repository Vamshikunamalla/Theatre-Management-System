package com.jsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.theatre_management_system.dao.BranchDao;
import com.jsp.theatre_management_system.dto.Address;
import com.jsp.theatre_management_system.dto.Branch;
import com.jsp.theatre_management_system.dto.Screen;
import com.jsp.theatre_management_system.dto.Staff;
import com.jsp.theatre_management_system.exception.AddressIdNotFound;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@Service
public class BranchService {
	@Autowired
	BranchDao branchDao;
    
	@Autowired
	ResponseStructure<Branch> responseStructure;
	@Autowired
	ResponseStructureList<Branch> responseStructureList;
	
		public ResponseStructure<Branch> saveBranch(Branch branch) {
			responseStructure.setStatusCoad(HttpStatus.CREATED.value());
	    	responseStructure.setMessage("Succesfully Saved Branch the  into db");
	    	responseStructure.setData(branchDao.saveBranch(branch));
		return	responseStructure;
		}
		public ResponseStructure<Branch> addExistingBranchToExisitingStaff(int branchId,int staffId) {
			Branch branch =branchDao.fetchBranchById(branchId);
			if(branch!=null) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully update addExistingBranchToExisitingStaff  into db");
	    	responseStructure.setData(branchDao.addExistingBranchToExisitingStaff(branchId, staffId));
		return responseStructure;} else {
			throw new AddressIdNotFound();
		}
		}
		public ResponseStructure<Branch> addExistingBranchToAddStaff(int branchId,Staff newStaff) {
			Branch branch =branchDao.fetchBranchById(branchId);
			if(branch!=null) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully update addExistingBranchToAddStaff  into db");
	    	responseStructure.setData(branchDao.addExistingBranchToAddStaff(branchId, newStaff));
		return responseStructure;}
			else {
			throw new AddressIdNotFound();
		}
			
		}
		public ResponseStructure<Branch> addExistingBranchToExisitingScreen(int branchId,int screenId) {
			Branch branch =branchDao.fetchBranchById(branchId);
			if(branch!=null) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully update addExistingBranchToExisitingScreen   into db");
	    	responseStructure.setData(branchDao.addExistingBranchToExisitingScreen(branchId, screenId));
	    return responseStructure;}
	    	else {
			throw new AddressIdNotFound();
		}
		}
		public ResponseStructure<Branch> addExistingBranchToAddScreen(int branchId,Screen newScreen) {
			Branch branch =branchDao.fetchBranchById(branchId);
			if(branch!=null) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully update addExistingBranchToAddScreen   into db");
	    	responseStructure.setData(branchDao.addExistingBranchToAddScreen(branchId, newScreen));
		return	responseStructure;}
	    	else {
			throw new AddressIdNotFound();
		}
		}
		public ResponseStructure<Branch> addExistingBranchToExistingAddress(int branchId,int addressId ) {
			Branch branch =branchDao.fetchBranchById(branchId);
			if(branch!=null) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully update addExistingBranchToExistingAddress   into db");
	    	responseStructure.setData(branchDao.addExistingBranchToExisitingStaff(branchId, addressId));
		return	responseStructure;}
    	else {
		throw new AddressIdNotFound();
	}
		}
		public ResponseStructure<Branch> addExistingBranchToAddNewAddress(int branchId,Address newAddress ) {
			Branch branch =branchDao.fetchBranchById(branchId);
			if(branch!=null) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully update addExistingBranchToAddNewAddress   into db");
	    	responseStructure.setData(branchDao.addExistingBranchToAddNewAddress(branchId, newAddress));
		return	responseStructure;}
    	else {
		throw new AddressIdNotFound();
	}
		}
		public ResponseStructure<Branch> fetchBranchById(int branchId) {
			Branch branch =branchDao.fetchBranchById(branchId);
			if(branch!=null) {
			responseStructure.setStatusCoad(HttpStatus.FOUND.value());
	    	responseStructure.setMessage("Succesfully  fetchBranchById form  db");
	    	responseStructure.setData(branchDao.fetchBranchById(branchId));
		return responseStructure;}
    	else {
		throw new AddressIdNotFound();
	}
		}
		public ResponseStructure<Branch> deleteBranchById(int branchId) {
			Branch branch =branchDao.fetchBranchById(branchId);
		if(branch!=null) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully update deleteBranchById from db");
	    	responseStructure.setData(branchDao.deleteBranchById(branchId));
		return	responseStructure;}
    	else {
		throw new AddressIdNotFound();
	}	
		}
		public ResponseStructure<Branch> updateBranchById(int oldBarnchId,Branch newBranch) {
			Branch branch =branchDao.fetchBranchById(oldBarnchId);
			if(branch!=null) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully update updateBranchById into db");
	    	responseStructure.setData(branchDao.saveBranch(newBranch));
		return	responseStructure;}
    	else {
		throw new AddressIdNotFound();
	}	
		}
		public ResponseStructureList<Branch> fetchAllBranchs() {
		
		  responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		  responseStructureList.setMessage("Succesfully  fetchAllBranchs in a db");
		  responseStructureList.setData(branchDao.fetchAllBranchs());
		return	responseStructureList;
		
				
			}
			
		}


