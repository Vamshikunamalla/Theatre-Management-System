package com.jsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.theatre_management_system.dao.ScreenDao;
import com.jsp.theatre_management_system.dto.Screen;
import com.jsp.theatre_management_system.dto.Seat;
import com.jsp.theatre_management_system.exception.ScreenIdNotFound;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;
@Service
public class ScreenService {
	@Autowired
     ScreenDao screenDao; 
	@Autowired
	ResponseStructure<Screen> responseStructure;
	@Autowired
	ResponseStructureList<Screen> responseStructureList;

	public ResponseStructure<Screen> saveScreen( Screen screen) {
		responseStructure.setStatusCoad(HttpStatus.CREATED.value());
    	responseStructure.setMessage("Succesfully Screen saved  the  into db");
    	responseStructure.setData(screenDao.saveScreen(screen));
	return responseStructure	;
	}
	public ResponseStructure<Screen> addExistingScreenToExisitingSeat(int seatId,int screenId) {
		Screen screen=screenDao.fetchScreenById(screenId);
		if(screen!=null) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
    	responseStructure.setMessage("Succesfully addExistingScreenToExisitingSeat  the  into db");
    	responseStructure.setData(screenDao.addExistingScreenToExisitingSeat(seatId, screenId));
	return	responseStructure;}
		else {
			throw new ScreenIdNotFound();
		}
	}
	public ResponseStructure<Screen> addExistingScreenToAddSeat(Seat newSeat,int screenId) {
		Screen screen=screenDao.fetchScreenById(screenId);
		if(screen!=null) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
    	responseStructure.setMessage("Succesfully Screen saved  the  into db");
    	responseStructure.setData(screenDao.addExistingScreenToAddSeat(newSeat, screenId));
	return responseStructure	;}
		else {
			throw new ScreenIdNotFound();
		}
	}
	
	public ResponseStructure<Screen> fetchScreenById(int screenId) {
		Screen screen=screenDao.fetchScreenById(screenId);
		if(screen!=null) {
		responseStructure.setStatusCoad(HttpStatus.FOUND.value());
    	responseStructure.setMessage("Succesfully fetchScreenById saved  the  into db");
    	responseStructure.setData(screenDao.fetchScreenById(screenId));
	return responseStructure	;}
		else {
			throw new ScreenIdNotFound();
		}
	}
	
	public ResponseStructure<Screen> deleteScreenById(int screenId) {
		Screen screen=screenDao.fetchScreenById(screenId);
		if(screen!=null) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
    	responseStructure.setMessage("Succesfully deleteScreenById  the  into db");
    	responseStructure.setData(screenDao.deleteScreenById(screenId));
	return 	responseStructure;}
		else {
			throw new ScreenIdNotFound();
		}
	}
	public ResponseStructure<Screen> updateScreenById(int oldScreenId, Screen newScreen) { 
		Screen screen=screenDao.fetchScreenById(oldScreenId);
		if(screen!=null) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
	    responseStructure.setMessage("Succesfully updateScreenById the  into db");
	    responseStructure.setData(screenDao.saveScreen(newScreen));
	return responseStructure	;}
		else {
			throw new ScreenIdNotFound();
		}	
	}
	public ResponseStructureList<Screen> fetchAllScreens(){
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setMessage("Succesfully fetchAllScreens from db");
		responseStructureList.setData(screenDao.fetchAllScreens());
	return responseStructureList	;
		
	}


}
