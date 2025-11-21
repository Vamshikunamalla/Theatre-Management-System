package com.jsp.theatre_management_system.dto;

import java.sql.Time;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int movieId;
	private String movieName;
	private String movietype;
	private Time movieDuration;
	private String movieLanguage;
	private double movieBudget;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Screen screen;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Review> reviews;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Viewer> viewers;
	
	
	
	public List<Viewer> getViewers() {
		return viewers;
	}
	public void setViewers(List<Viewer> viewers) {
		this.viewers = viewers;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovietype() {
		return movietype;
	}
	public void setMovietype(String movietype) {
		this.movietype = movietype;
	}
	public Time getMovieDuration() {
		return movieDuration;
	}
	public void setMovieDuration(Time movieDuration) {
		this.movieDuration = movieDuration;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public double getMovieBudget() {
		return movieBudget;
	}
	public void setMovieBudget(double movieBudget) {
		this.movieBudget = movieBudget;
	}
	
	
	
	
	
}
