package com.tempo.tempehum.accessingdatapostgres.repository;
import com.tempo.tempehum.accessingdatapostgres.model.Device;
import com.tempo.tempehum.accessingdatapostgres.model.Temperature;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface TemperatureRepository extends CrudRepository<Temperature, Integer> {
//
//    @Query("SELECT * FROM temperatures join devices on fk_device = devices.id")
//    public Iterable<Temperature> findByDevice(@Param("deviceName") String deviceName);
    List <Temperature> findByDevice(Device device);
}