package com.tempo.tempehum.accessingdatapostgres.repository;
import com.tempo.tempehum.accessingdatapostgres.model.Device;
import com.tempo.tempehum.accessingdatapostgres.model.Humidity;
import com.tempo.tempehum.accessingdatapostgres.model.Temperature;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface HumidityRespository extends CrudRepository<Humidity, Integer> {
    List<Humidity> findByDevice(Device device);
}