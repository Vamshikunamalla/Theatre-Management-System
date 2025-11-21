package com.jsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.theatre_management_system.dto.Food;
import com.jsp.theatre_management_system.dto.Viewer;
import com.jsp.theatre_management_system.service.ViewerService;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@RestController
public class ViewerController {
	@Autowired
	ViewerService viewerService;
	@PostMapping("/saveViewer")
	 public ResponseStructure<Viewer> saveViewer(@RequestBody Viewer viewer) {
		 return	viewerService.saveViewer(viewer);
		}
	@PutMapping("/addExistingViewerToExistingFood")
	 public ResponseStructure<Viewer> addExistingViewerToExistingFood(@RequestParam int viewerId,@RequestParam int foodId) {
		    return	viewerService.addExistingViewerToExistingFood(viewerId, foodId);
		    }
	
	@PutMapping("/addExistingViewerToAddFood")
		    public ResponseStructure<Viewer> addExistingViewerToAddFood(@RequestParam int viewerId,@RequestBody Food newfood) {
		    return	viewerService.addExistingViewerToAddFood(viewerId, newfood);
		    }
	@GetMapping("/fetchViewerById")
	public ResponseStructure<Viewer> fetchViewerById(@RequestParam int viewerId) {
		return	viewerService.fetchViewerById(viewerId);
		}
	@DeleteMapping("/deletetViewerById")	
		public ResponseStructure<Viewer> deletetViewerById(@RequestParam int viewerId) {
	    return	viewerService.deletetViewerById(viewerId);
	    }
	@PutMapping("/updateViewerById")	
		public ResponseStructure<Viewer> updateViewerById( @RequestParam int oldViewerId,@RequestBody Viewer newViewer) {
		return	viewerService.saveViewer(newViewer);
		}	
	@GetMapping("/fetchAllViewers")
	public ResponseStructureList<Viewer> fetchAllViewers(){
	    return viewerService.fetchAllViewers();
			
		}
	

}
