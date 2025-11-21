package com.jsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.theatre_management_system.dto.Branch;
import com.jsp.theatre_management_system.dto.Theatre;
import com.jsp.theatre_management_system.service.TheatreService;
import com.jsp.theatre_management_system.util.ResponseStructure;

@RestController
public class TheatreController {
@Autowired
TheatreService theatreService;

@PostMapping("/saveTheatre")
   public ResponseStructure<Theatre> saveTheatre(@RequestBody Theatre theater) {
	 return	theatreService.saveTheatre(theater);
	}
@GetMapping("/fetchTheatreById")
	public ResponseStructure<Theatre> fetchTheatreById(@RequestParam int theatreId) {
	return	theatreService.deletetTheatreById(theatreId);
	}
@PutMapping("/addExistingBranchToExistingTheatre")
public ResponseStructure<Theatre> addExistingBranchToExistingTheatre(@RequestParam int branchId,@RequestParam int theatreId ) {
 return	theatreService.addExistingBranchToExistingTheatre(branchId, theatreId);
}
@PutMapping("/addExistingBranchToAddTheatre")
public ResponseStructure<Theatre> addExistingBranchToAddTheatre(@RequestParam int theatreId,@RequestBody Branch newBranch ) {
 return	theatreService.addExistingBranchToAddTheatre(theatreId, newBranch);
}
@DeleteMapping("/deletetTheatreById")	
	public ResponseStructure<Theatre> deletetTheatreById(@RequestParam int theatreId) {
	 return	theatreService.deletetTheatreById(theatreId);
   }
@PutMapping("/updateTheatreById")	
	public ResponseStructure<Theatre> updateTheatreById( @RequestParam int oldTheatreId,@RequestBody Theatre newTheatre) {
	return	theatreService.saveTheatre(newTheatre);
	}
@GetMapping("/fetchAllTheatres")	
	public ResponseStructure<Theatre> fetchAllTheatres() {
 return theatreService.fetchAlTheatres();
		
	}

}
