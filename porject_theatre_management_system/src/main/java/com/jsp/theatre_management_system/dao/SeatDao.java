package com.jsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.theatre_management_system.Repo.SeatRepo;
import com.jsp.theatre_management_system.dto.Seat;

@Repository
public class SeatDao {
	@Autowired
	SeatRepo seatRepo;
	
	public Seat saveSeat( Seat seat) {
		return	seatRepo.save(seat);
		}
		public Seat fetchSeatById(int seatId) {
			Optional<Seat> seat=seatRepo.findById(seatId);
			if(seat.isPresent()) {
				return seat.get();
			}else {
				return null;}
		}
		
		public Seat deleteSeatById(int seatId) {
		  Seat seat=fetchSeatById(seatId);
			seatRepo.delete(seat);
			return seat;
		}
		public Seat updateSeatById(int oldSeatId, Seat newSeat) {
			newSeat.setSeatId(oldSeatId);
		return	seatRepo.save(newSeat);	
		}
		public List<Seat> fetchAllSeats(){
		return	seatRepo.findAll();
			
		}

}
