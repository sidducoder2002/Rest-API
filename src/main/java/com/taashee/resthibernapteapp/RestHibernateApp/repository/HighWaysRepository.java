package com.taashee.resthibernapteapp.RestHibernateApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taashee.resthibernapteapp.RestHibernateApp.entity.Highway;

@Repository
public interface HighWaysRepository extends CrudRepository<Highway, Integer>{

}
