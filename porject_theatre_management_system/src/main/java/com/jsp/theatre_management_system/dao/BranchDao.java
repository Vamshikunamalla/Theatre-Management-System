package com.jsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.theatre_management_system.Repo.BranchRepo;
import com.jsp.theatre_management_system.dto.Address;
import com.jsp.theatre_management_system.dto.Branch;
import com.jsp.theatre_management_system.dto.Screen;
import com.jsp.theatre_management_system.dto.Staff;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;
	@Autowired
	AddressDao addressDao;
	@Autowired
	ScreenDao screenDao;
	@Autowired
	StaffDao staffDao;
	
	public Branch saveBranch(Branch branch) {
	return	branchRepo.save(branch);
	}
	
	public Branch addExistingBranchToExisitingScreen(int branchId,int screenId) {
		Branch branch=fetchBranchById(branchId);
		screenDao.fetchScreenById(screenId);
		List<Screen>list=branch.getScreens();
		branch.setScreens(list);
		return saveBranch(branch);
	}
	public Branch addExistingBranchToExisitingStaff(int branchId,int staffId) {
		Branch branch=fetchBranchById(branchId);
     	staffDao.fatchStaffById(staffId); 
		List<Staff>list=branch.getStaffs();
		branch.setStaffs(list);
		return saveBranch(branch);
		
	}
	public Branch addExistingBranchToAddStaff(int branchId,Staff newStaff) {
		Branch branch=fetchBranchById(branchId);
		staffDao.saveStaff(newStaff);
		List<Staff>list=branch.getStaffs();
		branch.setStaffs(list);
		return saveBranch(branch);
	}
	
	public Branch addExistingBranchToAddScreen(int branchId,Screen newScreen) {
		Branch branch=fetchBranchById(branchId);
		screenDao.saveScreen(newScreen);
		List<Screen>list=branch.getScreens();
		branch.setScreens(list);
		return saveBranch(branch);
	}
	
	public Branch addExistingBranchToExistingAddress(int branchId,int addressId ){
		Branch branch=fetchBranchById(branchId);
		Address address=addressDao.ftchAddressById(addressId);
		branch.getAddress();
		branch.setAddress(address);
		return saveBranch(branch);
	}
	public Branch addExistingBranchToAddNewAddress(int branchId,Address newAddress ) {
		Branch branch =fetchBranchById(branchId);
//		Address address=addressDao.ftchAddressById(branchId);
//		branch.getAddress();
		branch.setAddress(newAddress);
		return saveBranch(branch);
		
	}
	public Branch fetchBranchById(int branchId) {
		Optional<Branch> branch=branchRepo.findById(branchId);
		if(branch.isPresent()) {
			return branch.get();
		}else {
			return null;
		}
	}
	public Branch deleteBranchById(int branchId) {
	Branch branch=	fetchBranchById(branchId);
		branchRepo.delete(branch);
		return branch;
	}
	public Branch updateBranchById(int oldBarnchId,Branch newBranch) {
		newBranch.setBranchId(oldBarnchId);
	return	branchRepo.save(newBranch);	
	}
	public List<Branch> fetchAllBranchs(){
	return	branchRepo.findAll();
		
	}
}
