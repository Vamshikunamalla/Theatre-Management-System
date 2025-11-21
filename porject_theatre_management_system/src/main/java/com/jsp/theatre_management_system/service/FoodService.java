package com.jsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.theatre_management_system.dao.FoodDao;
import com.jsp.theatre_management_system.dto.Food;
import com.jsp.theatre_management_system.exception.FoodIdNotFound;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@Service
public class FoodService {
	@Autowired
	FoodDao foodDao;
	@Autowired
	ResponseStructure<Food> responseStructure;
	@Autowired
	ResponseStructureList<Food> responseStructureList;
	
	    public ResponseStructure<Food> saveFood(Food food) {
	    	responseStructure.setStatusCoad(HttpStatus.CREATED.value());
	    	responseStructure.setMessage("Succesfully Food saved  the  into db");
	    	responseStructure.setData(foodDao.saveFood(food));
		return responseStructure	;
		}
		public ResponseStructure<Food> fatchFoodById(int foodId) {
		Food food=foodDao.fatchFoodById(foodId);
		if(food!=null){
			responseStructure.setStatusCoad(HttpStatus.FOUND.value());
	    	responseStructure.setMessage("Succesfully fatchFoodById from food in  db");
	    	responseStructure.setData(	foodDao.fatchFoodById(foodId));
		return responseStructure;}
		else {
			throw new FoodIdNotFound();}
		}
		public ResponseStructure<Food> deleteFoodById(int foodId) {
			Food food=foodDao.fatchFoodById(foodId);
			if(food!=null){
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully delete from db");
	    	responseStructure.setData(foodDao.deleteFoodById(foodId));
	    return	responseStructure;}
			else {
				throw new FoodIdNotFound();}
			}
			
		public ResponseStructure<Food> C(int OldfoodId,Food newFood) {
			Food food=foodDao.fatchFoodById(OldfoodId);
			if(food!=null){
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully update into db");
	    	responseStructure.setData(foodDao.saveFood(newFood));
	    return responseStructure;}
			else {
				throw new FoodIdNotFound();}
			}
		
		public ResponseStructureList<Food> fatchAllFoods() {
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setMessage("Succesfully fatchAllFoods from Food in db");
			responseStructureList.setData(foodDao.fatchAllFoods());
		return	 responseStructureList;
		
			}

}
