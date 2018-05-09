package com.hygogg.movies.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hygogg.movies.models.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
