package com.hygogg.movies.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.hygogg.movies.models.Movie;
import com.hygogg.movies.repositories.MovieRepository;

@Service
public class MovieService {
	
	private MovieRepository movieRepository;
	
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public Movie create(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public ArrayList<Movie> all() {
		return (ArrayList<Movie>) movieRepository.findAll();
	}

}
