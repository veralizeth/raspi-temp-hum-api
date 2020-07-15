package com.tempo.tempehum.accessingdatapostgres.repository;

import com.tempo.tempehum.accessingdatapostgres.model.Temperature;
import org.springframework.data.repository.CrudRepository;



public interface TemperatureRepository extends CrudRepository<Temperature, Integer> {

}