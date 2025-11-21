package com.jsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.theatre_management_system.dao.SeatDao;
import com.jsp.theatre_management_system.dto.Seat;
import com.jsp.theatre_management_system.exception.SeatIdNotFound;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@Service
public class SeatService {
	@Autowired
	SeatDao seatDao;
	@Autowired
	ResponseStructure<Seat> responseStructure;
	@Autowired
	ResponseStructureList<Seat> responseStructureList;
	
	    public ResponseStructure<Seat> saveSeat( Seat Seat) {
	    	responseStructure.setStatusCoad(HttpStatus.CREATED.value());
	    	responseStructure.setMessage("Succesfully Seat saved  the  into db");
	    	responseStructure.setData(seatDao.saveSeat(Seat));
		return	responseStructure;
		}
		public ResponseStructure<Seat> fetchSeatById(int seatId) {
			Seat seat=seatDao.fetchSeatById(seatId);
			if(seat!=null) {
			responseStructure.setStatusCoad(HttpStatus.FOUND.value());
	    	responseStructure.setMessage("Succesfully fetchSeatById the  into db");
	    	responseStructure.setData(seatDao.fetchSeatById(seatId));
		return	responseStructure;}
			else {
				throw new SeatIdNotFound();
			}
		}
		
		public ResponseStructure<Seat> deleteSeatById(int seatId) {
			Seat seat=seatDao.fetchSeatById(seatId);
			if(seat!=null) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully deleteSeatById  the  into db");
	    	responseStructure.setData(seatDao.deleteSeatById(seatId));
		return	responseStructure;}
			else {
				throw new SeatIdNotFound();
			}
			
		}
		public ResponseStructure<Seat> updateSeatById(int oldSeatId, Seat newSeat) {
			Seat seat=seatDao.fetchSeatById(oldSeatId);
			if(seat!=null) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully updateSeatById  the  into db");
	    	responseStructure.setData(seatDao.saveSeat(newSeat));
		return responseStructure	;}
			else {
				throw new SeatIdNotFound();
			}	
		}
		public ResponseStructureList<Seat> fetchAlSeats(){
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setMessage("Succesfully fetchAlSeats from db");
			responseStructureList.setData(seatDao.fetchAllSeats());
		return	responseStructureList;
			
		}


}
