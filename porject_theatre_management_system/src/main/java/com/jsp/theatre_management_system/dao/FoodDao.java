package com.jsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.theatre_management_system.Repo.FoodRepo;
import com.jsp.theatre_management_system.dto.Food;

@Repository
public class FoodDao {
	
	@Autowired
	FoodRepo foodRepo;
	
	public Food saveFood(Food food) {
	return	foodRepo.save(food);
	}
	public Food fatchFoodById(int foodId) {
		Optional<Food> food=foodRepo.findById(foodId);
		if(food.isPresent()) {
			return food.get();
		}else {
			return null;
		}
	}
	public Food deleteFoodById(int foodId) {
	Food food =fatchFoodById(foodId);
	foodRepo.delete(food);	
	return food;
	}
	public Food updateFoodById(int oldFoodId,Food newFood) {
	newFood.setFoodId(oldFoodId);
    return foodRepo.save(newFood);
	}
	public List<Food> fatchAllFoods(){
	return	foodRepo.findAll();
		}
}
