package com.tempo.tempehum.accessingdatapostgres.model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="HUMIDITIES")
public class Humidity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double value;
    private String timeStamp;

    @ManyToOne
    @JoinColumn(name = "fk_device")
    private Device device;

    public Humidity() {
    }

    public Humidity(double value, Device device, String timeStamp) {
        this.value = value;
        this.device = device;
        this.timeStamp = timeStamp;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public double getValue() { return value; }
    public void setValue(Double value) {
        this.value = value;
    }

    public String getTimeStamp() {return  timeStamp;}
    public void setTimeStamp(String timeStamp){
        this.timeStamp = timeStamp;
    }

}
