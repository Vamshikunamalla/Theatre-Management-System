package com.jsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.theatre_management_system.Repo.MovieRepo;
import com.jsp.theatre_management_system.dto.Movie;
import com.jsp.theatre_management_system.dto.Review;
import com.jsp.theatre_management_system.dto.Screen;
import com.jsp.theatre_management_system.dto.Viewer;

@Repository
public class MovieDao {
	@Autowired
	MovieRepo movieRepo;
	
	@Autowired
	ScreenDao screenDao;
	
	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	ViewerDao viewerDao;
	
	public Movie saveMovie(Movie movie) {
     return  movieRepo.save(movie);
	}
	
	public Movie addExistingMovieToExistingScreen(int movieId,int screenId ) {
	Movie movie  =fetchMovieById(movieId);
	Screen screen=screenDao.fetchScreenById(screenId);
	movie.getScreen();
	movie.setScreen(screen);
	return saveMovie(movie);
	}
	public Movie addExistingMovieToAddNewScreen(int movieId,Screen newScreen ) {
		 Movie movie =fetchMovieById(movieId);
		Screen screen = screenDao.saveScreen(newScreen);
		movie.getScreen();
		movie.setScreen(screen);
		return saveMovie(movie);
	}
	public Movie addExistingMovieToExistingRevies(int movieId,int reviesId ) {
		 Movie movie =fetchMovieById(movieId);
		reviewDao.fetchReviewById(reviesId);
		List<Review>list=movie.getReviews();
		movie.setReviews(list);
		return saveMovie(movie);
	}
	public Movie addExistingMovieToAddRevies(int movieId,Review newrReview ) {
		 Movie movie =fetchMovieById(movieId);
		 reviewDao.saveReview(newrReview);
		 List<Review>list=movie.getReviews();
		 movie.setReviews(list);
		 return saveMovie(movie);
	}
	
	public Movie addExistingMovieToExistingViewer(int movieId,int viewerId ) {
		 Movie movie =fetchMovieById(movieId);
		 viewerDao.fetchViewerById(viewerId);
		 List<Viewer>list=movie.getViewers();
		 movie.setViewers(list);
		 return saveMovie(movie);
	}
	public Movie addExistingMovieToAddViewer(int movieId,Viewer newViewer) {
		 Movie movie =fetchMovieById(movieId);
		 viewerDao.saveViewer(newViewer);
		 List<Viewer>list=movie.getViewers();
		 movie.setViewers(list);
		 return saveMovie(movie);
		 
	}
	
	public Movie fetchMovieById(int movieId) {
		Optional<Movie> movie=movieRepo.findById(movieId);
		if(movie.isPresent()) {
			return movie.get();
		}else {
			return null;
		}
	}
	public Movie deleteMovieById(int movieId) {
	Movie movie=fetchMovieById(movieId);
	movieRepo.delete(movie);
		return movie;
	}

	public Movie updateMovieById(int oldMovieId, Movie newMovie) {
		newMovie.setMovieId(oldMovieId);
	return	movieRepo.save(newMovie);
	}
	public List<Movie> fetchAllMovies(){
	return	movieRepo.findAll();
	}
}
