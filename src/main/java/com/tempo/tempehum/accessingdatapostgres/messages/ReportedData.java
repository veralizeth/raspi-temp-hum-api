package com.tempo.tempehum.accessingdatapostgres.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;
import java.sql.Timestamp;

public class ReportedData {

    private double temperature;
    private double humidity;
    private Timestamp timestamp;
    @JsonProperty("isOn")
    private boolean isOn;
    private String deviceName;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

}

