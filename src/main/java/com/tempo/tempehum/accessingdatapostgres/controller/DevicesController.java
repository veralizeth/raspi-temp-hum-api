package com.tempo.tempehum.accessingdatapostgres.controller;
import com.tempo.tempehum.accessingdatapostgres.model.Device;
import com.tempo.tempehum.accessingdatapostgres.model.Humidity;
import com.tempo.tempehum.accessingdatapostgres.model.Temperature;
import com.tempo.tempehum.accessingdatapostgres.repository.DeviceRepository;
import com.tempo.tempehum.accessingdatapostgres.repository.HumidityRepository;
import com.tempo.tempehum.accessingdatapostgres.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path="/api")
public class DevicesController {
    @Autowired // This means to get the bean called Repositories
    private DeviceRepository deviceRepository;

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Autowired
    private HumidityRepository humidityRepository;

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
        return humidityRepository.findByDevice(device);
    }

//    @GetMapping("/{date}/humidity")
//    @ResponseBody
//    public List <Humidity> getDateHum(@PathVariable String date)
//    {
//        Humidity humidity = (Humidity) humidityRespository.findByTimeStamp(date);
//        return humidityRespository.findByTimeStamp(date);
//    }

//    @GetMapping
//    public List <Humidity> getHumidityByDate(
//            @RequestParam(name = "date")
//            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                    LocalDate date) {
//        return humidityRespository.findByTimeStamp(date);
//        }
}