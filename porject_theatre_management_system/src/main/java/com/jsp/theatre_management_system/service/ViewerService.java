package com.jsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.theatre_management_system.dao.ViewerDao;
import com.jsp.theatre_management_system.dto.Food;
import com.jsp.theatre_management_system.dto.Seat;
import com.jsp.theatre_management_system.dto.Viewer;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@Service
public class ViewerService {
	@Autowired
	ViewerDao viewerDao;
	@Autowired
	ResponseStructure<Viewer> responseStructure;
	@Autowired
	ResponseStructureList<Viewer> responseStructureList;
	
	
	    public ResponseStructure<Viewer> saveViewer(Viewer viewer) {
	    	responseStructure.setStatusCoad(HttpStatus.CREATED.value());
	    	responseStructure.setMessage("Succesfully save Viewer   the  into db");
	    	responseStructure.setData(viewerDao.saveViewer(viewer));
		 return responseStructure	;
		}
	    public ResponseStructure<Viewer> addExistingViewerToExistingFood(int viewerId,int foodId) {
	    	responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully addExistingViewerToExistingFood  the  into db");
	    	responseStructure.setData(viewerDao.addExistingViewerToExistingFood(viewerId, foodId));
	    return	responseStructure;
	    }
	    public ResponseStructure<Viewer> addExistingViewerToAddFood(int viewerId,Food newfood) {
	    	responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully addExistingViewerToAddFood   the  into db");
	    	responseStructure.setData(viewerDao.addExistingViewerToAddFood(viewerId, newfood));
	    return	responseStructure;
	    }
	    
	    public ResponseStructure<Viewer> addExistingViewerToExistingSeat(int viewerId,int seatId) {
	    	responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully addExistingViewerToExistingSeat   the  into db");
	    	responseStructure.setData(viewerDao.addExistingViewerToExistingSeat(viewerId, seatId));
	    return	responseStructure;
	    }
		public ResponseStructure<Viewer> addExistingViewerToAddSeat(int viewerId,Seat newsSeat) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully addExistingViewerToAddSeat   the  into db");
	    	responseStructure.setData(viewerDao.addExistingViewerToAddSeat(viewerId, newsSeat));
		return responseStructure	;
		}
		public ResponseStructure<Viewer> fetchViewerById(int viewerId) {
			responseStructure.setStatusCoad(HttpStatus.FOUND.value());
	    	responseStructure.setMessage("Succesfully fetchViewerById  the  into db");
	    	responseStructure.setData(viewerDao.fetchViewerById(viewerId));
		return	 responseStructure;
		}
		
		public ResponseStructure<Viewer> deletetViewerById(int viewerId) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully deletetViewerById   the  into db");
	    	responseStructure.setData(viewerDao.deletetViewerById(viewerId));
	    return	responseStructure;
	    }
		
		public ResponseStructure<Viewer> updateViewerById(int oldViewerId, Viewer newViewer) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully updateViewerById   the  into db");
	    	responseStructure.setData(viewerDao.saveViewer(newViewer));
		return	responseStructure;
		}
		
		public ResponseStructureList<Viewer> fetchAllViewers(){
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setMessage("Succesfully fetchAllViewers from db");
			responseStructureList.setData(viewerDao.fetchAllViewers());
	    return responseStructureList;
			
		}

}
