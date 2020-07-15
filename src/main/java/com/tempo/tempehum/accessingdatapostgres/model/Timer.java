package com.tempo.tempehum.accessingdatapostgres.model;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity // This tells Hibernate to make a table out of this class
@Table(name="TIMERS")
public class Timer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Timestamp starTime;
    private Timestamp endTime;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "fk_device")
    private Device device;

    public Timer(){
    }
    // Constructor
    public Timer(Timestamp starTime, Timestamp endTime, boolean isActive, Device device) {
        this.starTime = starTime;
        this.endTime = endTime;
        this.isActive = isActive;
        this.device = device;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public Timestamp getStarTime() {
        return starTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public boolean isActive() {
        return isActive;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setStarTime(Timestamp starTime) {
        this.starTime = starTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
