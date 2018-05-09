package com.hygogg.movies.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hygogg.movies.models.Movie;
import com.hygogg.movies.services.MovieService;

@Controller
public class Movies {
	
	private MovieService movieService;
	
	public Movies(MovieService movieService) {
		this.movieService = movieService;
	}

	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("movie", new Movie());
		model.addAttribute("movies", movieService.all());
		return "index";
	}
	
	@PostMapping("movies")
	public String movies(@Valid @ModelAttribute("movie") Movie movie, BindingResult result) {
		System.out.println(movie.getTitle());
		movieService.create(movie);
		return "redirect:/";
	}
	
}
