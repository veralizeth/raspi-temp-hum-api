package com.tempo.tempehum.accessingdatapostgres.repository;
import com.tempo.tempehum.accessingdatapostgres.model.Device;
import com.tempo.tempehum.accessingdatapostgres.model.Humidity;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;


public interface HumidityRepository extends CrudRepository<Humidity, Integer> {
    List<Humidity> findByDevice(Device device);

//    List<Humidity> findAllByDate(Date timeStamp);

    List<Humidity> findAllByTimeStampBetween(
            Date timeStampStart,
            Date  timeStampEnd);
}