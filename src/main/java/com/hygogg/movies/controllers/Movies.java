package com.hygogg.movies.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hygogg.movies.models.Actor;
import com.hygogg.movies.models.Movie;
import com.hygogg.movies.services.ActorService;
import com.hygogg.movies.services.MovieService;

@Controller
public class Movies {
	
	private MovieService movieService;
	private ActorService actorService;
	
	public Movies(MovieService movieService, ActorService actorService) {
		this.movieService = movieService;
		this.actorService = actorService;
	}

	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("movie", new Movie());
		model.addAttribute("actress", new Actor());
		model.addAttribute("movies", movieService.all());
		model.addAttribute("actresses", actorService.all());
		return "index";
	}
	
	@PostMapping("movies")
	public String movies(@Valid @ModelAttribute("movie") Movie movie, BindingResult result, Model model) {
		System.out.println(movie.getTitle());
		if (result.hasErrors()) {
			model.addAttribute("movies", movieService.all());
			List<ObjectError> errors = result.getAllErrors();
			for (int i=0; i<errors.size(); i++) {
				System.out.println(errors.get(i).getDefaultMessage());
			}
			return "index";
		}
		movieService.create(movie);
		return "redirect:/";
	}
	
}
