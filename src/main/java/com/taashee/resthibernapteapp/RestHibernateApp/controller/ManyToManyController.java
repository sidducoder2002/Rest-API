package com.taashee.resthibernapteapp.RestHibernateApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taashee.resthibernapteapp.RestHibernateApp.entity.City;
import com.taashee.resthibernapteapp.RestHibernateApp.entity.Highway;
import com.taashee.resthibernapteapp.RestHibernateApp.entity.State;
import com.taashee.resthibernapteapp.RestHibernateApp.repository.HighWaysRepository;
import com.taashee.resthibernapteapp.RestHibernateApp.repository.StateRepository;

@RestController()
@RequestMapping(("/manyToMany"))
public class ManyToManyController {
    
    private final StateRepository stateRepository;
    private final HighWaysRepository highwayRepository;
    
    @Autowired
    public ManyToManyController(StateRepository stateRepository, HighWaysRepository highwayRepository) {
        this.stateRepository = stateRepository;
        this.highwayRepository = highwayRepository;
    }

    @GetMapping("/states")
    public List<State> getStates() {
        return (List<State>) stateRepository.findAll();
    }

    @PostMapping("/state")
    public State saveState(@RequestBody State state) {
        return stateRepository.save(state);
    }
    
    @GetMapping("/highways")
    public List<Highway> getHighways() {
        return (List<Highway>) highwayRepository.findAll();
    }
    
    @PutMapping("/highway/{highwayId}/state/{stateId}")
	public State assignBankToAccount(@PathVariable int highwayId,
			@PathVariable int stateId) {
		Highway highway=highwayRepository.findById(highwayId).get();
		State state=stateRepository.findById(stateId).get();
		
		state.getHighways().add(highway);
		return stateRepository.save(state);
	}
    
    @PostMapping("/highway")
    public Highway saveHighway(@RequestBody Highway highway) {
        return highwayRepository.save(highway);
    }

}
