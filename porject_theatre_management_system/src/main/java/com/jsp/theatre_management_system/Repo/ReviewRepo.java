package com.jsp.theatre_management_system.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.theatre_management_system.dto.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer>{

}
