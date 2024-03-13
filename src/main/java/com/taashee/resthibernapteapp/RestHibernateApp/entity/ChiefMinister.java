package com.taashee.resthibernapteapp.RestHibernateApp.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class ChiefMinister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="chief_minister_name" ,unique = true)
    private String chiefMinisterName;

    @JsonIgnore
    @OneToOne(mappedBy = "chiefMinister")
    private State state;


	public ChiefMinister() {
		
	}


	public ChiefMinister(int id, String chiefMinisterName, State state) {
		this.id = id;
		this.chiefMinisterName = chiefMinisterName;
		this.state = state;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getChiefMinisterName() {
		return chiefMinisterName;
	}


	public void setChiefMinisterName(String chiefMinisterName) {
		this.chiefMinisterName = chiefMinisterName;
	}


	public State getState() {
		return state;
	}


	public void setState(State state) {
		this.state = state;
	}
}
