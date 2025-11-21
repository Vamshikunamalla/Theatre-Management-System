package com.jsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.theatre_management_system.dao.StaffDao;
import com.jsp.theatre_management_system.dto.Staff;
import com.jsp.theatre_management_system.exception.StaffIdNotFound;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@Service
public class StaffSerive  {

	@Autowired
	StaffDao staffDao;
	@Autowired
	ResponseStructure<Staff> responseStructure;
	@Autowired
	ResponseStructureList<Staff> responseStructureList;
	
	public ResponseStructure<Staff> saveStaff(Staff staff) {
		responseStructure.setStatusCoad(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully saved Staff in to db");
		responseStructure.setData(staffDao.saveStaff(staff));
		return responseStructure;
	}
	public ResponseStructure<Staff> fatchStaffById(int staffId) {
		Staff staff=staffDao.fatchStaffById(staffId);
		if(staff!=null) {
			responseStructure.setStatusCoad(HttpStatus.FOUND.value());
			responseStructure.setMessage("Succesfully fatch from  db");
			responseStructure.setData(staffDao.fatchStaffById(staffId));
			return responseStructure;}
		else {
			throw new StaffIdNotFound();
			}
		}
	public ResponseStructure<Staff> deletStaffById(int staffId) {
		Staff staff=staffDao.fatchStaffById(staffId);
	if(staff!=null) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Delet from  db");
		responseStructure.setData(staffDao.deletStaffById(staffId));
		return responseStructure;}
	else {
		throw new StaffIdNotFound();
		}
	}
	public ResponseStructure<Staff> updateStaffById(int oldStaffId,Staff newStaff) {
		Staff staff=staffDao.fatchStaffById(oldStaffId);
	if(staff!=null) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
		responseStructure.setMessage("Succesfully Delet from  db");
		responseStructure.setData(staffDao.saveStaff(newStaff));
		return responseStructure;}
	else {
		throw new StaffIdNotFound();
		}
		
	}
	public ResponseStructureList<Staff> fetchAllStaffs(){
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully fetchAll from  db");
		responseStructureList.setData(staffDao.fatchAllStaffs());
		return responseStructureList;
	}
}
