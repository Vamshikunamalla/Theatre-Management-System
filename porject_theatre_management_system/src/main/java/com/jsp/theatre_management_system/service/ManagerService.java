package com.jsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.theatre_management_system.dao.ManagerDao;
import com.jsp.theatre_management_system.dto.Branch;
import com.jsp.theatre_management_system.dto.Manager;
import com.jsp.theatre_management_system.exception.ManagerIdNotFound;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@Service
public class ManagerService {
	@Autowired
	ManagerDao managerDao;
	@Autowired
	ResponseStructure<Manager> responseStructure;
	@Autowired
	ResponseStructureList<Manager> responseStructureList;
	
	public ResponseStructure<Manager> saveManager(Manager manager) {	
		responseStructure.setStatusCoad(HttpStatus.CREATED.value());
    	responseStructure.setMessage("Succesfully Manager saved  the  into db");
    	responseStructure.setData(managerDao.saveManager(manager));
	    return	responseStructure;
		}
	
	 public ResponseStructure<Manager> addExistingManagerToExistingBranch(int managerId,int branchId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		if(manager!=null) {
		 responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully addExistingManagerToExistingBranch  into db");
	    	responseStructure.setData(managerDao.addExistingManagerToExistingBranch(managerId, branchId));
		return responseStructure;}
		else {
			throw new ManagerIdNotFound();
		}
	 }
	 public ResponseStructure<Manager> addExistingManagerToAddBranch(int managerId,Branch newBranch) {
		 Manager manager = managerDao.fetchManagerById(managerId);
			if(manager!=null) {
		 responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully addExistingManagerToExistingBranch  into db");
	    	responseStructure.setData( managerDao.addExistingManagerToAddBranch(managerId, newBranch));
	return responseStructure;}
	else {
		throw new ManagerIdNotFound();
	}
	 }
		public ResponseStructure<Manager> fetchManagerById(int managerId) {
			Manager manager = managerDao.fetchManagerById(managerId);
		if(manager!=null) {
			responseStructure.setStatusCoad(HttpStatus.FOUND.value());
	    	responseStructure.setMessage("Succesfully fetchManagerById   into db");
	    	responseStructure.setData(managerDao.fetchManagerById(managerId));
		return responseStructure ;}
		else {
			throw new ManagerIdNotFound();
		}
		}
		public ResponseStructure<Manager> deleteManagerById(int managerId){
			Manager manager = managerDao.fetchManagerById(managerId);
			if(manager!=null) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully delete from db");
	    	responseStructure.setData(managerDao.deleteManagerById(managerId));
	     return	responseStructure;}
			else {
				throw new ManagerIdNotFound();
			}
			
		}
		
		public ResponseStructure<Manager> updateManagerById(int oldManagerId,Manager newManager) {
			Manager manager = managerDao.fetchManagerById(oldManagerId);
			if(manager!=null) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully update by ManagerById in db");
	    	responseStructure.setData(managerDao.updateManagerById(oldManagerId, newManager));
	   return responseStructure	;}
		else {
			throw new ManagerIdNotFound();
		}
}
			
	   public ResponseStructureList<Manager> fetchAllManagers(){
		   responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		   responseStructureList.setMessage("Succesfully fetchAllManagers in db");
		   responseStructureList.setData(managerDao.fetchAllManagers());
		return  responseStructureList ;

}
	   
}
