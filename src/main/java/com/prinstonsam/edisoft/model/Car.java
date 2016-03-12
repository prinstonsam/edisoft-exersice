package com.prinstonsam.edisoft.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by samsik on 29.02.16.
 */
@Entity
@Table(name = "car")
public class Car {

    public Car() {
    }

    public Car(String serialNumber, Transmission transmission, Engine engine, Body body) {
        this.serialNumber = serialNumber;
        this.transmission = transmission;
        this.engine = engine;
        this.body = body;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "serial_number")
    private String serialNumber;

    @OneToOne
    @JoinColumn(name = "transmission_id", unique = true)
    private Transmission transmission;

    @OneToOne
    @JoinColumn(name = "engine_id", unique = true)
    private Engine engine;

    @OneToOne
    @JoinColumn(name = "body_id", unique = true)
    private Body body;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(serialNumber, car.serialNumber) &&
                Objects.equals(transmission, car.transmission) &&
                Objects.equals(engine, car.engine) &&
                Objects.equals(body, car.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, transmission, engine, body);
    }
}
