package com.jsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.theatre_management_system.dto.Screen;
import com.jsp.theatre_management_system.dto.Seat;
import com.jsp.theatre_management_system.service.ScreenService;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@RestController
public class ScreenController {
		@Autowired
		ScreenService screenService;
		@PostMapping("/saveScreen")
		public ResponseStructure<Screen> saveScreen(@RequestBody Screen screen) {
			return	screenService.saveScreen(screen);
			}
		@PutMapping("/addExistingScreenToExisitingSeat")
		public ResponseStructure<Screen> addExistingScreenToExisitingSeat(@RequestParam int seatId,@RequestParam int screenId) {
			return	screenService.addExistingScreenToExisitingSeat(seatId, screenId);
			}
		@PutMapping("/addExistingScreenToAddSeat")
			public ResponseStructure<Screen> addExistingScreenToAddSeat(@RequestBody Seat newSeat,@RequestParam int screenId) {
			return	screenService.addExistingScreenToAddSeat(newSeat, screenId);
			}
		@GetMapping("/fetchScreenById")
			public ResponseStructure<Screen> fetchScreenById(@RequestParam int screenId) {
			return	screenService.fetchScreenById(screenId);
			}
		@DeleteMapping("/deleteScreenById")	
			public ResponseStructure<Screen> deleteScreenById(@RequestParam int screenId) {
			return	screenService.deleteScreenById(screenId);
			}
		@PutMapping("/updateScreenById")
			public ResponseStructure<Screen> updateScreenById(@RequestParam int oldScreenId,@RequestBody Screen newScreen) {
			return	screenService.saveScreen(newScreen);	
			}
		@GetMapping("/fetchAllScreen")
			public ResponseStructureList<Screen> fetchAllScreens(){
			return	screenService.fetchAllScreens();
				
			}

}
