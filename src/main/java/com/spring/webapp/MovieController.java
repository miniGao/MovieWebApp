package com.spring.webapp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {
	@Autowired
	private IMovieRepository movieRepo;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("movieList", movieRepo.findAll());
		return "index";
	}
	
	@GetMapping("/addMovie")
	public String addMovie(Movie movie) {
		return "addMovie";
	}
	
	@PostMapping("/createMovie")
	public String createMovie(@Valid Movie movie, BindingResult result, Model model) {
		if(result.hasErrors()) return "addMovie";
		movieRepo.save(movie);
		model.addAttribute("movieList", movieRepo.findAll());
		return "index";
	}
	
	@GetMapping("/editMovie/{id}")
	public String editMovie(@PathVariable("id") int movieId, Model model) {
		Movie movie = movieRepo.findById(movieId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + movieId));
		model.addAttribute("movie", movie);
		return "updateMovie";
	}
	
	@PostMapping("/updateMovie/{id}")
	public String updateMovie(@PathVariable("id") int movieId, @Valid Movie movie, BindingResult result, Model model) {
		movie.setMovieId(movieId);
		if(result.hasErrors()) return "updateMovie";
		movieRepo.save(movie);
		model.addAttribute("movieList", movieRepo.findAll());
		return "index";
	}
	
	@GetMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable("id") int movieId, Model model) {
		Movie movie = movieRepo.findById(movieId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + movieId));
		movieRepo.delete(movie);
		model.addAttribute("movieList", movieRepo.findAll());
		return "index";
	}
}
