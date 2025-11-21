package com.jsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.theatre_management_system.Repo.TheatreRepo;
import com.jsp.theatre_management_system.dto.Branch;
import com.jsp.theatre_management_system.dto.Theatre;

@Repository
public class TheatreDao {
    @Autowired 
	TheatreRepo theatreRepo ;
    @Autowired
    BranchDao branchDao;
   
	
	public Theatre saveTheatre(Theatre theater) {
	 return	theatreRepo.save(theater);
	}
	public Theatre addExistingBranchToExistingTheatre(int branchId,int theatreId ) {
		Branch branch=branchDao.fetchBranchById(branchId);
		Theatre theatre=theatreRepo.findById(theatreId).get();
		List<Branch>list= theatre.getBranch();
		list.add(branch);
		theatre.setBranch(list);
		return saveTheatre(theatre);
	}
	public Theatre addExistingBranchToAddTheatre(int theatreId,Branch newBranch ) {
		Theatre theatre=fetchTheatreById(theatreId);
		Branch branch=branchDao.saveBranch(newBranch);
		List<Branch>list=theatre.getBranch();
		list.add(branch);
		theatre.setBranch(list);
		return saveTheatre(theatre);
		
	}
	
	
	public Theatre fetchTheatreById(int theatreId) {
		Optional<Theatre> theatre=theatreRepo.findById(theatreId);
		if(theatre.isPresent()) {
			return theatre.get();
		}else {
			return null;}
	}
	
	public Theatre deletetTheatreById(int theatreId) {
	Theatre	theatre=fetchTheatreById(theatreId);
	theatreRepo.delete(theatre);
	return theatre;
	}
	
	public Theatre updateTheatreById(int oldTheatreId, Theatre newTheatre) {
		newTheatre.setTheatreId(oldTheatreId);
	return	theatreRepo.save(newTheatre);
	}
	
	public List<Theatre> fetchAllTheatres(){
  return theatreRepo.findAll();
		
	}
}
