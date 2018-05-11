package com.hygogg.movies.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hygogg.movies.models.Actor;
import com.hygogg.movies.models.Movie;
import com.hygogg.movies.services.ActorService;
import com.hygogg.movies.services.MovieService;

@Controller
public class Actors {
	
private MovieService movieService;
private ActorService actorService;
	
	public Actors(MovieService movieService, ActorService actorService) {
		this.movieService = movieService;
		this.actorService = actorService;
	}

	@PostMapping("actors")
	public String actress(@Valid @ModelAttribute("actress") Actor actress, BindingResult result, Model model) {
		System.out.println(actress.getName());
		if(result.hasErrors()) {
			model.addAttribute("movie", new Movie());
			model.addAttribute("movies", movieService.all());
			return "index";
		}
		actorService.create(actress);
		return "redirect:/";
	}
	
	@RequestMapping("actor/{id}")
	public String actor(@PathVariable Long id, Model model) {
		model.addAttribute("actress", actorService.findById(id));
		return "actress";
	}
	
	@PostMapping("actor/{id}/update")
	public String update(@Valid @ModelAttribute("actress") Actor actress, BindingResult result, Model model) {
		System.out.println(actress.getName());
		if(result.hasErrors()) {
			return "actress";
		}
		actorService.update(actress);
		return "redirect:/";
	}
	
	@PostMapping("actor/{id}/delete/")
	public String delete(@PathVariable Long id) {
		actorService.delete(id);
		return "redirect:/";
	}
}
