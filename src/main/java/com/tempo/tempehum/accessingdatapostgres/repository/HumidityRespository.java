package com.tempo.tempehum.accessingdatapostgres.repository;
import com.tempo.tempehum.accessingdatapostgres.model.Humidity;
import org.springframework.data.repository.CrudRepository;


public interface HumidityRespository extends CrudRepository<Humidity, Integer> {

}