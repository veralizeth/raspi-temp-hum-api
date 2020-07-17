package com.tempo.tempehum.accessingdatapostgres.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="HUMIDITIES", indexes = {
        @Index(columnList = "id", name = "humidity_id_idx")
})
public class Humidity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double value;
    private Timestamp timeStamp;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    public Humidity() {
    }

    public Humidity(double value, Device device, Timestamp timeStamp) {
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

    public Timestamp getTimeStamp() {return  timeStamp;}
    public void setTimeStamp(Timestamp timeStamp){
        this.timeStamp = timeStamp;
    }

}
