package com.taashee.resthibernapteapp.RestHibernateApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taashee.resthibernapteapp.RestHibernateApp.entity.City;
import com.taashee.resthibernapteapp.RestHibernateApp.entity.State;
import com.taashee.resthibernapteapp.RestHibernateApp.repository.CityRepository;
import com.taashee.resthibernapteapp.RestHibernateApp.repository.StateRepository;

@RestController
@RequestMapping(("/oneToMany"))
public class OneToManyController {
	private final StateRepository stateRepo;
	private final CityRepository cityRepo;
	
	@Autowired
	public OneToManyController(StateRepository stateRepo, CityRepository cityRepo) {
		this.stateRepo = stateRepo;
		this.cityRepo = cityRepo;
	}

	@GetMapping("/cities")
	public List<City> getCities() {
		return (List<City>) cityRepo.findAll();
	}
	
	

	@PostMapping("/city")
	public ResponseEntity<City> saveAccount(@RequestBody City city) {
		return new ResponseEntity<City>( cityRepo.save(city), HttpStatus.CREATED);
	}
	@GetMapping("/states")
	public List<State> getStates(){
		return (List<State>) stateRepo.findAll();
	}
	@PostMapping("/state")
	public State saveState(@RequestBody  State state) {
		return stateRepo.save(state);
	}
	
	
	@PutMapping("/city/{cityId}/state/{stateId}")
	public City assignBankToAccount(@PathVariable int cityId,
			@PathVariable int stateId) {
		City city=cityRepo.findById(cityId).get();
		State state=stateRepo.findById(stateId).get();
		city.setState(state);
		return cityRepo.save(city);
	}
	@DeleteMapping("/state/{id}")
	public ResponseEntity<Void> deleteBank(@PathVariable int id){
		stateRepo.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
}
