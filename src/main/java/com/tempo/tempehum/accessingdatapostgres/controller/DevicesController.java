package com.tempo.tempehum.accessingdatapostgres.controller;
import com.tempo.tempehum.accessingdatapostgres.model.Device;
import com.tempo.tempehum.accessingdatapostgres.model.Humidity;
import com.tempo.tempehum.accessingdatapostgres.model.Temperature;
import com.tempo.tempehum.accessingdatapostgres.repository.DeviceRepository;
import com.tempo.tempehum.accessingdatapostgres.repository.HumidityRespository;
import com.tempo.tempehum.accessingdatapostgres.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/api")
public class DevicesController {
    @Autowired // This means to get the bean called Repositories
    private DeviceRepository deviceRepository;

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Autowired
    private HumidityRespository humidityRespository;

    @GetMapping(path="/devices")
    public @ResponseBody Iterable<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @GetMapping("/{deviceName}/temperature")
    @ResponseBody
    public List <Temperature> getAlltemperatures(@PathVariable String deviceName)
    {
        Device device = deviceRepository.findByDeviceName(deviceName);
        return temperatureRepository.findByDevice(device);
    }

    @GetMapping("/{deviceName}/humidity")
    @ResponseBody
    public List <Humidity> getAllHumidities(@PathVariable String deviceName)
    {
        Device device = deviceRepository.findByDeviceName(deviceName);
        return humidityRespository.findByDevice(device);
    }
}