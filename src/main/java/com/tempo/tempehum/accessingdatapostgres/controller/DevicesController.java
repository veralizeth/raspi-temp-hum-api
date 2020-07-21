package com.tempo.tempehum.accessingdatapostgres.controller;
import com.tempo.tempehum.accessingdatapostgres.model.Device;
import com.tempo.tempehum.accessingdatapostgres.model.Humidity;
import com.tempo.tempehum.accessingdatapostgres.model.Temperature;
import com.tempo.tempehum.accessingdatapostgres.repository.DeviceRepository;
import com.tempo.tempehum.accessingdatapostgres.repository.HumidityRepository;
import com.tempo.tempehum.accessingdatapostgres.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
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

    @GetMapping("/humidity")
    @ResponseBody
    public List<Humidity> getHumidity(@RequestParam String timeStampStart, @RequestParam String timeStampEnd) {

        Instant startInstant = Instant.parse(timeStampStart);
        Instant endInstant = Instant.parse(timeStampEnd);
        Date startDate = Date.from(startInstant);
        Date endDate = Date.from(endInstant);

        return humidityRepository.findAllByTimeStampBetween(Sort.by("timeStamp"),startDate, endDate);
    }

    @GetMapping("/temperature")
    @ResponseBody
    public List<Temperature> getTemperature(@RequestParam String timeStampStart, @RequestParam String timeStampEnd) {

        Instant startInstant = Instant.parse(timeStampStart);
        Instant endInstant = Instant.parse(timeStampEnd);
        Date startDate = Date.from(startInstant);
        Date endDate = Date.from(endInstant);

        return temperatureRepository.findAllByTimeStampBetween(Sort.by("timeStamp"), startDate, endDate);
    }


    @GetMapping("/temperature/date")
    @ResponseBody
    public Temperature getCurrentTemperature(@RequestParam String timeStamp) {

        Instant timeStampInstant = Instant.parse(timeStamp);

        Date timeStampDate = Date.from(timeStampInstant);

        return temperatureRepository.findByTimeStamp(timeStampDate);
    }

    @GetMapping("/humidity/date")
    @ResponseBody
    public Humidity getCurrentHuminity(@RequestParam String timeStamp) {

        Instant timeStampInstant = Instant.parse(timeStamp);

        Date timeStampDate = Date.from(timeStampInstant);

        return humidityRepository.findByTimeStamp(timeStampDate);
    }
}