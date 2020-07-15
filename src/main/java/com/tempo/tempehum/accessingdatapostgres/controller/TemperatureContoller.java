package com.tempo.tempehum.accessingdatapostgres.controller;

import com.tempo.tempehum.accessingdatapostgres.model.Device;
import com.tempo.tempehum.accessingdatapostgres.model.Temperature;
import com.tempo.tempehum.accessingdatapostgres.model.User;
import com.tempo.tempehum.accessingdatapostgres.repository.DeviceRepository;
import com.tempo.tempehum.accessingdatapostgres.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/temperatures")
public class TemperatureContoller {
    @Autowired
    private TemperatureRepository temperatureRepository;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Temperature> getAllTemperatures() {
        // This returns a JSON or XML with the users
        return temperatureRepository.findAll();
    }
}


