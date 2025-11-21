package com.jsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.theatre_management_system.dao.ReviewDao;
import com.jsp.theatre_management_system.dto.Review;
import com.jsp.theatre_management_system.exception.ReviewIdNotFound;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@Service
public class ReviewService {
	@Autowired
	ReviewDao reviewDao;
	@Autowired
	ResponseStructure<Review> responseStructure;
	@Autowired
	ResponseStructureList<Review> responseStructureList;
	
	
	        public ResponseStructure<Review> saveReview( Review review) {
	        	responseStructure.setStatusCoad(HttpStatus.CREATED.value());
		    	responseStructure.setMessage("Succesfully Review saved  the  into db");
		    	responseStructure.setData(reviewDao.saveReview(review));
			return  responseStructure;
			}
			public ResponseStructure<Review> fetchReviewById(int ReviewId) {
				Review review=reviewDao.fetchReviewById(ReviewId);
				if(review!=null) {
				responseStructure.setStatusCoad(HttpStatus.FOUND.value());
		    	responseStructure.setMessage("Succesfully fetchReviewById  the  into db");
		    	responseStructure.setData( reviewDao.fetchReviewById(ReviewId));
			return responseStructure;}
				else {
					throw new ReviewIdNotFound();
				}
			}
			public ResponseStructure<Review> deleteReviewById(int ReviewId) {
				Review review=reviewDao.fetchReviewById(ReviewId);
				if(review!=null) {
				responseStructure.setStatusCoad(HttpStatus.OK.value());
		    	responseStructure.setMessage("Succesfully deleteReviewById  the  into db");
		    	responseStructure.setData(reviewDao.deleteReviewById(ReviewId));
			return responseStructure;}
				else {
					throw new ReviewIdNotFound();
				}
			}
			public ResponseStructure<Review> updateReviewById(int oldReviewId, Review newReview) {
				Review review=reviewDao.fetchReviewById(oldReviewId);
				if(review!=null) {
				responseStructure.setStatusCoad(HttpStatus.OK.value());
		    	responseStructure.setMessage("Succesfully updateReviewById the  into db");
		    	responseStructure.setData(reviewDao.saveReview(newReview));
			return responseStructure;}
			else {
				throw new ReviewIdNotFound();
			}	
			}
			public ResponseStructureList<Review> fetchAllReviews(){
				responseStructureList.setStatusCode(HttpStatus.FOUND.value());
				responseStructureList.setMessage("Succesfully fetchAllReviews the  into db");
				responseStructureList.setData(reviewDao.fetchAllReviews());
			return responseStructureList ;
				
			}

}
