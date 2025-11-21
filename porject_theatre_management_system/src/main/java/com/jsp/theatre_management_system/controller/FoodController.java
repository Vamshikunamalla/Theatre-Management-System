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
import com.jsp.theatre_management_system.service.FoodService;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;
@RestController
public class FoodController {
	
	@Autowired
	FoodService foodService;
	
	@PostMapping("/saveFood")
	 		public ResponseStructure<Food> saveFood(@RequestBody Food food) {
			return	foodService.saveFood(food);
			}
	@GetMapping("/fatchFoodById")
			public ResponseStructure<Food> fatchFoodById(@RequestParam int foodId) {
			return	foodService.fatchFoodById(foodId);
			}
	@DeleteMapping("/deletFoodById")
			public ResponseStructure<Food> deletFoodById(@RequestParam int FoodId) {
		    return	foodService.deleteFoodById(FoodId);	
			}
	@PutMapping("/updateFoodById")
			public ResponseStructure<Food> updateFoodById(@RequestParam int oldfoodId,@RequestBody Food newFood) {
		    return foodService.saveFood(newFood);
			}
	@GetMapping("/fatchAllFoods")
			public ResponseStructureList<Food> fatchAllFoods(){
			return	foodService.fatchAllFoods();
				}
	

}
