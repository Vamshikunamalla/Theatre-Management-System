package com.jsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.theatre_management_system.Repo.ScreenRepo;
import com.jsp.theatre_management_system.dto.Screen;
import com.jsp.theatre_management_system.dto.Seat;

@Repository
public class ScreenDao {
	@Autowired
	ScreenRepo screenRepo;
	
	@Autowired
	SeatDao seatDao;
	public Screen saveScreen( Screen screen) {
	return	screenRepo.save(screen);
	}
	public Screen addExistingScreenToExisitingSeat(int seatId,int screenId) {
		Screen screen=fetchScreenById(screenId);
		seatDao.fetchSeatById(seatId);
		List<Seat>list=screen.getSeats();
		screen.setSeats(list);
		return saveScreen(screen);
	}
	public Screen addExistingScreenToAddSeat(Seat newSeat,int screenId) {
		Screen screen=fetchScreenById(screenId);
		seatDao.saveSeat(newSeat);
		List<Seat>list=screen.getSeats();
		screen.setSeats(list);
		return saveScreen(screen);
	}
	public Screen fetchScreenById(int screenId) {
		Optional<Screen> screen=screenRepo.findById(screenId);
		if(screen.isPresent()) {
			return screen.get();
		}else {
			return null;
	}
	}
	
	public Screen deleteScreenById(int screenId) {
	  Screen screen=fetchScreenById(screenId);
		screenRepo.delete(screen);
		return screen;
	}
	public Screen updateScreenById(int oldScreenId, Screen newScreen) {
		newScreen.setScreenId(oldScreenId);
	return	screenRepo.save(newScreen);	
	}
	public List<Screen> fetchAllScreens(){
	return	screenRepo.findAll();
		
	}
	
}
