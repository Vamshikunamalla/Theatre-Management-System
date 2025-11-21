package com.jsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.theatre_management_system.Repo.ViewerRepo;
import com.jsp.theatre_management_system.dto.Food;
import com.jsp.theatre_management_system.dto.Seat;
import com.jsp.theatre_management_system.dto.Viewer;

@Repository
public class ViewerDao {
	@Autowired
	ViewerRepo viewerRepo;
	@Autowired
	FoodDao foodDao;
	@Autowired
	SeatDao seatDao;
	
	
	public Viewer saveViewer(Viewer viewer) {
		 return	viewerRepo.save(viewer);
		}
	public Viewer addExistingViewerToExistingSeat(int viewerId,int seatId) {
		Viewer viewer =fetchViewerById(viewerId);
		Seat seat=seatDao.fetchSeatById(seatId);
//		viewer.getSeat();
		viewer.setSeat(seat);
		return saveViewer(viewer);
	}
	public Viewer addExistingViewerToAddSeat(int viewerId,Seat newsSeat) {
		Viewer viewer =fetchViewerById(viewerId);
		seatDao.saveSeat(newsSeat);
		viewer.setSeat(newsSeat);
		return saveViewer(viewer);
	}
	
	public Viewer addExistingViewerToExistingFood(int viewerId,int foodId) {
		Viewer viewer=fetchViewerById(viewerId);
		foodDao.fatchFoodById(foodId);
		List<Food>list=viewer.getFoods();
		viewer.setFoods(list);
		return saveViewer(viewer);
	}
	
	
	public Viewer addExistingViewerToAddFood(int viewerId,Food newfood) {
		Viewer viewer=fetchViewerById(viewerId);
		foodDao.saveFood(newfood);
		List<Food>list=viewer.getFoods();
		viewer.setFoods(list);
		return saveViewer(viewer);
	}
	
		public Viewer fetchViewerById(int viewerId) {
			Optional<Viewer> viewer=viewerRepo.findById(viewerId);
			if(viewer.isPresent()) {
				return viewer.get();
			}else {
				return null;}
		
		}
		
		public Viewer deletetViewerById(int viewerId) {
		Viewer	viewer=fetchViewerById(viewerId);
		viewerRepo.delete(viewer);
		return viewer;
		}
		
		public Viewer updateViewerById(int oldViewerId, Viewer newViewer) {
			newViewer.setViewerId(oldViewerId);
		return	viewerRepo.save(newViewer);
		}
		
		public List<Viewer> fetchAllViewers(){
	  return viewerRepo.findAll();
			
		}

}
