package com.spring.webapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Movie")
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int movieId;
	@NotBlank(message="Movie name required")
	private String movieName;
	@NotBlank(message="Movie language required")
	private String movieLanguage;
	@NotBlank(message="Movie Genre required")
	private String movieGenre;
	@NotBlank(message="Duration required")
	@Pattern(regexp="[0-9]{1,}hr[0-5]{1}[0-9]{1}min", message="Follow format: 1hr30min (not more than 59 in minutes)")
	private String duration;
	
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
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
}
