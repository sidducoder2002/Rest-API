package com.taashee.resthibernapteapp.RestHibernateApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taashee.resthibernapteapp.RestHibernateApp.entity.ChiefMinister;
import com.taashee.resthibernapteapp.RestHibernateApp.entity.State;

@Repository
public interface ChiefMinisterRepository extends CrudRepository<ChiefMinister, Integer> {

}
