package com.hygogg.movies.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.hygogg.movies.models.Actor;
import com.hygogg.movies.repositories.ActressRepository;

@Service
public class ActorService {

	private ActressRepository actressRepository;
	
	public ActorService(ActressRepository actressRepository) {
		this.actressRepository = actressRepository;
	}
	
	public Actor create(Actor actress) {
		return actressRepository.save(actress);
	}
	
	public ArrayList<Actor> all(){
		return (ArrayList<Actor>) actressRepository.findAll();
	}
	
	public Actor findById(Long id) {
		return (Actor) actressRepository.findById(id);
	}
	
	public Actor update(Actor actress) {
		return actressRepository.save(actress);
	}
	
	public void delete(Long id) {
		actressRepository.delete(id);
	}
	
}
