package com.taashee.resthibernapteapp.RestHibernateApp.entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="state_name" ,unique = true)
    private String stateName;

    @OneToOne
    @JoinColumn(name = "chief_minister_id")
    private ChiefMinister chiefMinister;
    

    
    @OneToMany(mappedBy = "state" , cascade =CascadeType.ALL)
    private List<City> cities;
    
    @ManyToMany
    @JoinTable(name = "state_highway_rel",
            joinColumns = @JoinColumn(name = "state_id"),
            inverseJoinColumns = @JoinColumn(name = "highway_id"))
    private Set<Highway> highways = new HashSet<>();
    
    public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public Set<Highway> getHighways() {
		return highways;
	}

	public void setHighways(Set<Highway> highways) {
		this.highways = highways;
	}

	
    
	public State() {
		
	}

	public State(int id, String stateName, ChiefMinister chiefMinister, List<City> cities) {

		this.id = id;
		this.stateName = stateName;
		this.chiefMinister = chiefMinister;
		this.cities = cities;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public ChiefMinister getChiefMinister() {
		return chiefMinister;
	}

	public void setChiefMinister(ChiefMinister chiefMinister) {
		this.chiefMinister = chiefMinister;
	}
}
