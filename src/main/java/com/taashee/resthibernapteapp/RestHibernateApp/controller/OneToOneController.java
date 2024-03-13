package com.taashee.resthibernapteapp.RestHibernateApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taashee.resthibernapteapp.RestHibernateApp.entity.ChiefMinister;
import com.taashee.resthibernapteapp.RestHibernateApp.entity.State;
import com.taashee.resthibernapteapp.RestHibernateApp.repository.ChiefMinisterRepository;
import com.taashee.resthibernapteapp.RestHibernateApp.repository.StateRepository;

@RestController()
@RequestMapping(("/oneToOne"))
public class OneToOneController {
	private final StateRepository stateRepo;
	private final ChiefMinisterRepository chiefRepo;
	@Autowired
	public OneToOneController(StateRepository stateRepo, ChiefMinisterRepository chiefRepo) {
		this.stateRepo = stateRepo;
		this.chiefRepo = chiefRepo;
	}
	@GetMapping("/ministers")
	public List<ChiefMinister> getministers(){
		return (List<ChiefMinister>) chiefRepo.findAll();
	}
	
	@PostMapping("/minister")
	public ChiefMinister saveMinister(@RequestBody  ChiefMinister minister) {
		return chiefRepo.save(minister);
	}
	@GetMapping("/states")
	public List<State> getStates(){
		return (List<State>) stateRepo.findAll();
	}
	@PostMapping("/state")
	public State saveState(@RequestBody  State aadhar) {
		return stateRepo.save(aadhar);
	}
}
