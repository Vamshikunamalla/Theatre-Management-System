package com.jsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.theatre_management_system.dto.Review;
import com.jsp.theatre_management_system.service.ReviewService;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@RestController
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@PostMapping("/saveReview")
	        public ResponseStructure<Review> saveReview(@RequestBody Review review) {
			return reviewService.saveReview(review);
			}
	@GetMapping("/fetchReviewById")
			public ResponseStructure<Review> fetchReviewById(@RequestParam int ReviewId) {
			return reviewService.fetchReviewById(ReviewId);
			}
	@DeleteMapping("/deleteReviewById")
			public ResponseStructure<Review> deleteReviewById(@RequestParam int ReviewId) {
			return reviewService.deleteReviewById(ReviewId);
			}
	@PutMapping("/updateReviewById")
			public ResponseStructure<Review> updateReviewById(@RequestParam int oldReviewId,@RequestParam Review newReview) {
			return reviewService.saveReview(newReview);	
			}
	@GetMapping("/fetchAllReviews")
			public ResponseStructureList<Review> fetchAllReviews(){
			return reviewService.fetchAllReviews();
				
			}
	

}
