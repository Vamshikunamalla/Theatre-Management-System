package com.jsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.theatre_management_system.dao.MovieDao;
import com.jsp.theatre_management_system.dto.Movie;
import com.jsp.theatre_management_system.dto.Review;
import com.jsp.theatre_management_system.dto.Screen;
import com.jsp.theatre_management_system.dto.Viewer;
import com.jsp.theatre_management_system.exception.MovieIdNotFound;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@Service
public class MovieService {
	@Autowired
	MovieDao movieDao;
	@Autowired
	ResponseStructure<Movie> responseStructure;
	@Autowired
	ResponseStructureList<Movie> responseStructureList;
	
	public ResponseStructure<Movie> saveMovie(Movie movie) {
		responseStructure.setStatusCoad(HttpStatus.CREATED.value());
    	responseStructure.setMessage("Succesfully Movie saved  the  into db");
    	responseStructure.setData( movieDao.saveMovie(movie));
	     return responseStructure;
		}
	
	public ResponseStructure<Movie> addExistingMovieToExistingScreen(int movieId,int screenId ) {
		Movie movie=movieDao.fetchMovieById(movieId);
		if (movie!=null) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
    	responseStructure.setMessage("Succesfully addExistingMovieToExistingScreen   into db");
    	responseStructure.setData(movieDao.addExistingMovieToExistingScreen(movieId, screenId));
	return responseStructure;}
		else {
			throw new MovieIdNotFound();
		}
	}
	public ResponseStructure<Movie> addExistingMovieToAddNewScreen(int movieId,Screen newScreen ) {
		Movie movie=movieDao.fetchMovieById(movieId);
		if (movie!=null) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
    	responseStructure.setMessage("Succesfully addExistingMovieToAddNewScreen   into db");
    	responseStructure.setData(movieDao.addExistingMovieToAddNewScreen(movieId, newScreen));
	return responseStructure;}
		else {
			throw new MovieIdNotFound();
		}
	}
	public ResponseStructure<Movie> addExistingMovieToExistingRevies(int movieId,int reviesId ) {
		Movie movie=movieDao.fetchMovieById(movieId);
		if (movie!=null) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
    	responseStructure.setMessage("Succesfully addExistingMovieToExistingRevies   into db");
    	responseStructure.setData(movieDao.addExistingMovieToExistingRevies(movieId, reviesId));
	return	responseStructure;}
		else {
			throw new MovieIdNotFound();
		}
	}
	
	public ResponseStructure<Movie> addExistingMovieToAddRevies(int movieId,Review newrReview ) {
		Movie movie=movieDao.fetchMovieById(movieId);
	if (movie!=null) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
    	responseStructure.setMessage("Succesfully addExistingMovieToExistingScreen   into db");
    	responseStructure.setData(movieDao.addExistingMovieToAddRevies(movieId, newrReview));
	return responseStructure;}
	else {
		throw new MovieIdNotFound();
	}
	}
	
	public ResponseStructure<Movie> addExistingMovieToExistingViewer(int movieId,int viewerId ) {
		Movie movie=movieDao.fetchMovieById(movieId);
		if (movie!=null) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
    	responseStructure.setMessage("Succesfully addExistingMovieToExistingViewer   into db");
    	responseStructure.setData(movieDao.addExistingMovieToExistingViewer(movieId, viewerId));
	return responseStructure;}
		else {
			throw new MovieIdNotFound();
		}
	}
	public ResponseStructure<Movie> addExistingMovieToAddViewer(int movieId,Viewer newViewer) {
		Movie movie=movieDao.fetchMovieById(movieId);
		if (movie!=null) {
		responseStructure.setStatusCoad(HttpStatus.OK.value());
    	responseStructure.setMessage("Succesfully addExistingMovieToExistingScreen   into db");
    	responseStructure.setData(movieDao.addExistingMovieToAddViewer(movieId,newViewer));
	return responseStructure;}
		else {
			throw new MovieIdNotFound();
		}
	}
		public ResponseStructure<Movie> fetchMovieById(int movieId) {
			Movie movie=movieDao.fetchMovieById(movieId);
			if (movie!=null) {
			responseStructure.setStatusCoad(HttpStatus.FOUND.value());
	    	responseStructure.setMessage("Succesfully fetchMovieById   into db");
	    	responseStructure.setData(movieDao.fetchMovieById(movieId));
		return	responseStructure;}
			else {
				throw new MovieIdNotFound();
			}
		}
		public ResponseStructure<Movie> deleteMovieById(int movieId) {
			Movie movie=movieDao.fetchMovieById(movieId);
			if (movie!=null) { 
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully deleteMovieById  into db");
	    	responseStructure.setData( movieDao.deleteMovieById(movieId));
		return responseStructure;}
			else {
				throw new MovieIdNotFound();
			}	
		}
		public ResponseStructure<Movie> updateMovieById(int oldMovieId, Movie newMovie) {
			Movie movie=movieDao.fetchMovieById(oldMovieId);
			if (movie!=null) {
			responseStructure.setStatusCoad(HttpStatus.OK.value());
	    	responseStructure.setMessage("Succesfully addExistingMovieToExistingScreen   into db");
	    	responseStructure.setData(movieDao.saveMovie(newMovie));
		return responseStructure;}
			else {
				throw new MovieIdNotFound();
			}
		}
		public ResponseStructureList<Movie> fetchAllMovies(){
			responseStructureList.setStatusCode(HttpStatus.FOUND.value());
			responseStructureList.setMessage("Succesfully fetchAllMovies  from db ");
			responseStructureList.setData(movieDao.fetchAllMovies());
		return responseStructureList	;
		}

}
