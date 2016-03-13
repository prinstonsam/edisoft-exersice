package com.prinstonsam.edisoft.model;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "engine")
public class Engine {

    public Engine() {
    }

    public Engine(String serialNumber, Float volume, Float power, TypeEngine typeEngine) {
        this.serialNumber = serialNumber;
        this.volume = volume;
        this.power = power;
        this.typeEngine = typeEngine;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;


    @Column(name = "volume")
    private Float volume;

    @Column(name = "power")
    private Float power;

    @ManyToOne
    @JoinColumn(name="type_engine_id", nullable = true)
    @JsonManagedReference
    private TypeEngine typeEngine;

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

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public void setTypeEngine(TypeEngine typeEngine) {
        this.typeEngine = typeEngine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return Objects.equals(id, engine.id) &&
                Objects.equals(serialNumber, engine.serialNumber) &&
                Objects.equals(volume, engine.volume) &&
                Objects.equals(power, engine.power) &&
                Objects.equals(typeEngine, engine.typeEngine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNumber, volume, power, typeEngine);
    }
}


