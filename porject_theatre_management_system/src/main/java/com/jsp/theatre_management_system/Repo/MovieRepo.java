package com.jsp.theatre_management_system.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.theatre_management_system.dto.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer>{

}
