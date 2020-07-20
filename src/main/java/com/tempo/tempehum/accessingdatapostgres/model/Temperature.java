package com.tempo.tempehum.accessingdatapostgres.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity // This tells Hibernate to make a table out of this class
@Table(name="TEMPERATURES", indexes = {
        @Index(columnList = "id", name = "temperature_id_idx")
})
public class Temperature implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double value;
    private Date timeStamp;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    public Temperature() {
    }

    public Temperature(double value, Device device, Date timeStamp) {
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


