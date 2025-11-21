package com.jsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.theatre_management_system.dto.Branch;
import com.jsp.theatre_management_system.dto.Manager;
import com.jsp.theatre_management_system.service.ManagerService;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@RestController
public class ManagerController {
	@Autowired
	ManagerService managerService;
	
	@PostMapping("/saveManager")
	public ResponseStructure<Manager> saveManager(@RequestBody Manager manager) {	
	    return	managerService.saveManager(manager);
		}
	@PutMapping("/addExistingManagerToExistingBranch")
	 public ResponseStructure<Manager> addExistingManagerToExistingBranch(@RequestParam int managerId,@RequestParam int branchId) {
		 return managerService.addExistingManagerToExistingBranch(managerId, branchId);
	 }
	@PutMapping("/addExistingManagerToAddBranchs")
	public ResponseStructure<Manager> addExistingManagerToAddBranch(@RequestParam int managerId,@RequestBody Branch newBranch) {
	return	managerService.addExistingManagerToAddBranch(managerId, newBranch);
	}
	
		@GetMapping("/fetchManagerById")
		public ResponseStructure<Manager> fetchManagerById(@RequestParam int ManagerId) {
		return	managerService.fetchManagerById(ManagerId);
		}
		@DeleteMapping("/deleteManagerById")
		public ResponseStructure<Manager> deleteManagerById(@RequestParam int ManagerId){
	     return	managerService.deleteManagerById(ManagerId);
			
		}
		@PutMapping("/updateManagerById")
		public ResponseStructure<Manager> updateManagerById(@RequestParam int oldManagerId,@RequestBody Manager newManager) {
	return	managerService.updateManagerById(oldManagerId, newManager);
		}
			
		@GetMapping("/fetchAllManagers")
	   public ResponseStructureList<Manager> fetchAllManagers() {
		return   managerService.fetchAllManagers();
}
	

}
