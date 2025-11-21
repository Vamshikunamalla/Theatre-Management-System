package com.jsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.theatre_management_system.dto.Staff;
import com.jsp.theatre_management_system.service.StaffSerive;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

public class StaffController {

	@Autowired
	StaffSerive staffSerive;
	@PostMapping("/SaveStaff")
	 public ResponseStructure<Staff> SaveStaff(@RequestBody Staff staff) {
		return staffSerive.saveStaff(staff);
	 }
	@GetMapping("/fatchStaffById")
	public ResponseStructure<Staff> fatchStaffById(@RequestParam int staffId) {
		return staffSerive.fatchStaffById(staffId);
	}
	@DeleteMapping("/deletStaffById")
	public ResponseStructure<Staff> deletStaffById(@RequestParam int staffId) {
		return staffSerive.deletStaffById(staffId);
	}
	@PutMapping("/updateStaffById")
	public ResponseStructure<Staff> updateStaffById(@RequestBody int oldStaffId,@RequestParam Staff newStaff) {
		return staffSerive.saveStaff(newStaff);
	}
	@GetMapping("/fetchAllStaffs")
	public ResponseStructureList<Staff> fetchAllStaffs(){
		return staffSerive.fetchAllStaffs();
	}
}
