package com.jsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.theatre_management_system.dto.Movie;
import com.jsp.theatre_management_system.dto.Review;
import com.jsp.theatre_management_system.dto.Screen;
import com.jsp.theatre_management_system.dto.Viewer;
import com.jsp.theatre_management_system.service.MovieService;
import com.jsp.theatre_management_system.util.ResponseStructure;
import com.jsp.theatre_management_system.util.ResponseStructureList;

@RestController
public class MovieController {
	@Autowired
	MovieService movieService;
@PostMapping("/saveMovie")
	public ResponseStructure<Movie> saveMovie(@RequestBody Movie movie) {
	     return  movieService.saveMovie(movie);
		}
@PutMapping("/addExistingMovieToExistingScreen")
public ResponseStructure<Movie> addExistingMovieToExistingScreen(@RequestParam int  movieId,@RequestParam int screenId ) {
return	movieService.addExistingMovieToExistingScreen(movieId, screenId);
}
@PutMapping("/addExistingMovieToAddNewScreen")
public ResponseStructure<Movie> addExistingMovieToAddNewScreen(@RequestParam int movieId,@RequestBody Screen newScreen ) {
return	movieService.addExistingMovieToAddNewScreen(movieId, newScreen);
}
@PutMapping("/addExistingMovieToExistingRevies")
public ResponseStructure<Movie> addExistingMovieToExistingRevies(@RequestParam int movieId,@RequestParam int reviesId ) {
	return	movieService.addExistingMovieToExistingRevies(movieId, reviesId);
	}
@PutMapping("/addExistingMovieToAddRevies")
	public ResponseStructure<Movie> addExistingMovieToAddRevies(@RequestParam int movieId,@RequestBody Review newrReview ) {
	return	movieService.addExistingMovieToAddRevies(movieId, newrReview);
	}
@PutMapping("/addExistingMovieToExistingViewer")
    public ResponseStructure<Movie> addExistingMovieToExistingViewer(@RequestParam int movieId,@RequestParam int viewerId ) {
	return	movieService.addExistingMovieToExistingViewer(movieId, viewerId);
	}
@PutMapping("/addExistingMovieToAddViewer")
	public ResponseStructure<Movie> addExistingMovieToAddViewer(@RequestParam int movieId,@RequestBody Viewer newViewer) {
	return	movieService.addExistingMovieToAddViewer(movieId,newViewer);
	}
@GetMapping("/fetchMovieById")
		public ResponseStructure<Movie> fetchMovieById(@RequestParam int movieId) {
		return	movieService.fetchMovieById(movieId);
		}
@DeleteMapping("/deleteMovieById")
		public ResponseStructure<Movie> deleteMovieById(@RequestParam int movieId) {
		return movieService.deleteMovieById(movieId);	
		}
@PutMapping("/updateMovieById")
		public ResponseStructure<Movie> updateMovieById( @RequestParam int oldMovieId,@RequestBody Movie newMovie) {
		return	movieService.saveMovie(newMovie);
		}
@GetMapping("/fetchAllMovies")
		public ResponseStructureList<Movie> fetchAllMovies(){
		return	movieService.fetchAllMovies();
		}

}
