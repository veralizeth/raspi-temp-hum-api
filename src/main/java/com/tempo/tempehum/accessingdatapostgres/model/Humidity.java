package com.tempo.tempehum.accessingdatapostgres.model;

import javax.persistence.*;
import java.util.Date;
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

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    public Humidity() {
    }

    public Humidity(double value, Device device, Date timeStamp) {
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

    public Date getTimeStamp() {return  timeStamp;}
    public void setTimeStamp(Date timeStamp){
        this.timeStamp = timeStamp;
    }

}
