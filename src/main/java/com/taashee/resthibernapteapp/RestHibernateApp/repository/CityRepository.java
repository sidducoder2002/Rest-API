package com.taashee.resthibernapteapp.RestHibernateApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taashee.resthibernapteapp.RestHibernateApp.entity.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

}
