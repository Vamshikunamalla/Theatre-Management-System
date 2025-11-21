package com.jsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.theatre_management_system.Repo.ManagerRepo;
import com.jsp.theatre_management_system.dto.Branch;
import com.jsp.theatre_management_system.dto.Manager;
@Repository
public class ManagerDao {
	
	@Autowired
	ManagerRepo managerRepo;
	
	@Autowired
	BranchDao branchDao;
	
	    public Manager saveManager(Manager manager) {	
	    return	managerRepo.save(manager);
		}
	    public Manager addExistingManagerToExistingBranch(int managerId,int branchId) {
	    	Manager manager=fetchManagerById(managerId);
	    	Branch branch =branchDao.fetchBranchById(branchId);
	    	manager.getBranch();
	    	manager.setBranch(branch);
	    	return saveManager(manager);
	    }
	    public Manager addExistingManagerToAddBranch(int managerId,Branch newBranch) {
	    	Manager manager=fetchManagerById(managerId);
	    	Branch branch=branchDao.saveBranch(newBranch);
	    	manager.getBranch();
	    	manager.setBranch(branch);
	    	return saveManager(manager);
	    }
		public Manager fetchManagerById(int managerId) {
			Optional<Manager> manager=managerRepo.findById(managerId);
			if( manager.isPresent()) {
				return manager.get();
			}else {
				return null;
			}
		}
		public Manager deleteManagerById(int managerId){
		Manager manager=managerRepo.findById(managerId).get();
		managerRepo.delete(manager);
			return manager;
		}
		
		public Manager updateManagerById(int oldManagerId,Manager newManager) {
		newManager.setManagerId(oldManagerId);
	   return	managerRepo.save(newManager);
		}
			
	   public List<Manager> fetchAllManagers(){
		return   managerRepo.findAll();
}

}