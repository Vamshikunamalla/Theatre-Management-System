package com.jsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.theatre_management_system.dao.TheatreDao;
import com.jsp.theatre_management_system.dto.Branch;
import com.jsp.theatre_management_system.dto.Theatre;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;
@Service
public class TheatreService {
 
	@Autowired
	TheatreDao theatreDao;
	
	@Autowired
	ResponseStructure<Theatre> responseStructure;
	@Autowired
	ResponseStructureList<Theatre> responseStructureList;
	
	public ResponseStructure<Theatre> saveTheatre(Theatre theater) {
		responseStructure.setStatusCoad(HttpStatus.CREATED.value());
    	responseStructure.setMessage("Succesfully save Theatre   the  into db");
    	responseStructure.setData(theatreDao.saveTheatre(theater));
	 return	responseStructure;
	}
	
	public ResponseStructure<Theatre> addExistingBranchToExistingTheatre(int branchId,int theatreId ) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
    	responseStructure.setMessage("Succesfully save Theatre   the  into db");
    	responseStructure.setData(theatreDao.addExistingBranchToAddTheatre(theatreId, null));
	 return	responseStructure;
		
	}
	
	public ResponseStructure<Theatre> addExistingBranchToAddTheatre(int theatreId,Branch newBranch ) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
    	responseStructure.setMessage("Succesfully addExistingBranchToAddTheatre  the  into db");
    	responseStructure.setData(theatreDao.addExistingBranchToAddTheatre(theatreId, newBranch));
	 return	responseStructure;

	}
	public ResponseStructure<Theatre> fetchTheatreById(int theatreId) {
		responseStructure.setStatusCoad(HttpStatus.FOUND.value());
    	responseStructure.setMessage("Succesfully save Theatre   the  into db");
    	responseStructure.setData(theatreDao.deletetTheatreById(theatreId));
	 return	responseStructure;
	}
	
	public ResponseStructure<Theatre> deletetTheatreById(int theatreId) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
    	responseStructure.setMessage("Succesfully save Theatre   the  into db");
    	responseStructure.setData(theatreDao.deletetTheatreById(theatreId));
	 return responseStructure;
    }
	
	public ResponseStructure<Theatre> updateTheatreById(int oldTheatreId, Theatre newTheatre) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
    	responseStructure.setMessage("Succesfully save Theatre   the  into db");
    	responseStructure.setData(theatreDao.saveTheatre(newTheatre));
	return responseStructure	;
	}
	
	public ResponseStructure<Theatre> fetchAlTheatres(){
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully fetchAlSeats from db");
		responseStructureList.setData(theatreDao.fetchAllTheatres());
  return responseStructure;
		
	}
}
