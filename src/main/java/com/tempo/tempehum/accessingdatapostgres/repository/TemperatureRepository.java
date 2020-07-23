package com.tempo.tempehum.accessingdatapostgres.repository;
import com.tempo.tempehum.accessingdatapostgres.model.Device;
import com.tempo.tempehum.accessingdatapostgres.model.Temperature;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;


public interface TemperatureRepository extends CrudRepository<Temperature, Integer> {

    List <Temperature> findByDevice(Device device);

    List<Temperature> findAllByTimeStampBetween(
            Sort timeStamp, Date timeStampStart,
            Date timeStampEnd);

    Temperature findByTimeStamp(Date timeStamp);

    @Query(
            value = "SELECT * FROM temperatures WHERE DATE_TRUNC('day',time_stamp) = CURRENT_DATE - interval '1 day'",
            nativeQuery = true)
    List<Temperature> findAllTemperaturesNative();



}