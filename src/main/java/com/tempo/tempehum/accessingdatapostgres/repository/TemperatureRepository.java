package com.tempo.tempehum.accessingdatapostgres.repository;
import com.tempo.tempehum.accessingdatapostgres.model.Device;
import com.tempo.tempehum.accessingdatapostgres.model.Temperature;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;


public interface TemperatureRepository extends CrudRepository<Temperature, Integer> {

    List <Temperature> findByDevice(Device device);

    List<Temperature> findAllByTimeStampBetween(
            Sort timeStamp, Date timeStampStart,
            Date timeStampEnd);
}