package com.hygogg.movies.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hygogg.movies.models.Actor;

public interface ActressRepository extends CrudRepository<Actor, Long> {
	public Actor findById(Long id);
}
