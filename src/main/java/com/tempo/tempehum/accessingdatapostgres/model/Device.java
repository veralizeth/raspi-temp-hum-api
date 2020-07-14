package com.tempo.tempehum.accessingdatapostgres.model;
import javax.persistence.*;
import java.io.Serializable;

// marker annotation, which is used to discover persistent entities
@Entity // This tells Hibernate to make a table out of this class
@Table(name="DEVICES")
public class Device implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String deviceName;

    @ManyToOne
    @JoinColumn(name="fk_user")
    private User user;

    public Device() {
    }

    public Device(String deviceName, User user) {
        this.deviceName = deviceName;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return deviceName;
    }

    public void setName(String deviceName) {
        this.deviceName = deviceName;
    }

}
