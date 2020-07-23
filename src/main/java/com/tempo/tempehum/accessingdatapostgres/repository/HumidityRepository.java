package com.tempo.tempehum.accessingdatapostgres.repository;
import com.tempo.tempehum.accessingdatapostgres.model.Device;
import com.tempo.tempehum.accessingdatapostgres.model.Humidity;
import com.tempo.tempehum.accessingdatapostgres.model.Temperature;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;


public interface HumidityRepository extends CrudRepository<Humidity, Integer> {
    List<Humidity> findByDevice(Device device);

//    List<Humidity> findAllByDate(Date timeStamp);

    List<Humidity> findAllByTimeStampBetween(
            Sort timeStamp,
            Date timeStampStart,
            Date  timeStampEnd);

    Humidity findByTimeStamp(Date timeStamp);

    @Query(
            value = "SELECT * FROM humidities WHERE DATE_TRUNC('day',time_stamp) = CURRENT_DATE - interval '1 day'",
            nativeQuery = true)
    List<Humidity> findAllHumiditiesNative();
}