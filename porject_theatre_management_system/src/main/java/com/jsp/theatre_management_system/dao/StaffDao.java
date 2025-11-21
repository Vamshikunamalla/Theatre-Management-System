package com.jsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.theatre_management_system.Repo.StaffRepo;
import com.jsp.theatre_management_system.dto.Staff;
@Repository
public class StaffDao {
	
	@Autowired
	StaffRepo staffRepo;
	
	public Staff saveStaff(Staff staff) {
		return	staffRepo.save(staff);
		}
		public Staff fatchStaffById(int staffId) {
			Optional<Staff> staff=staffRepo.findById(staffId);
			if(staff.isPresent()) {
				return staff.get();
			}else {
				return null;}
	
		}
		public Staff deletStaffById(int staffId) {
		Staff staff =fatchStaffById(staffId);
		staffRepo.delete(staff);	
		return staff;
		}
		public Staff updateStaffById(int oldStaffId,Staff newStaff) {
		newStaff.setStaffId(oldStaffId);
	    return staffRepo.save(newStaff);
		}
		public List<Staff> fatchAllStaffs(){
		return	staffRepo.findAll();
			}

}
