package com.jsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.theatre_management_system.Repo.ReviewRepo;
import com.jsp.theatre_management_system.dto.Review;

@Repository
public class ReviewDao {
@Autowired
ReviewRepo reviewRepo;
	
	    public Review saveReview( Review review) {
		return reviewRepo.save(review);
		}
		public Review fetchReviewById(int reviewId) {
			Optional<Review> review=reviewRepo.findById(reviewId);
			if(review.isPresent()) {
				return review.get();
			}else {
				return null;
		}
		}
		public Review deleteReviewById(int ReviewId) {
		  Review Review=fetchReviewById(ReviewId);
		reviewRepo.delete(Review);
			return Review;
		}
		public Review updateReviewById(int oldReviewId, Review newReview) {
			newReview.setReviewId(oldReviewId);
		return reviewRepo.save(newReview);	
		}
		public List<Review> fetchAllReviews(){
		return reviewRepo.findAll();
			
		}

}
