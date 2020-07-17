package com.tempo.tempehum.accessingdatapostgres.repository;
import com.tempo.tempehum.accessingdatapostgres.model.Device;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface DeviceRepository extends CrudRepository<Device, Integer> {
    Device findByDeviceName(String deviceName);
}