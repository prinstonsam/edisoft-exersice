package com.prinstonsam.edisoft.model;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "transmission")
public class Transmission {

    public Transmission() {
    }

    public Transmission(String serialNumber, TypeTransmission typeTransmission) {
        this.typeTransmission = typeTransmission;
        this.serialNumber = serialNumber;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "type_transmission_id", nullable = true)
    @JsonManagedReference
    private TypeTransmission typeTransmission;

    private String serialNumber;

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

    public TypeTransmission getTypeTransmission() {
        return typeTransmission;
    }

    public void setTypeTransmission(TypeTransmission typeTransmission) {
        this.typeTransmission = typeTransmission;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transmission that = (Transmission) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(typeTransmission, that.typeTransmission) &&
                Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeTransmission, serialNumber);
    }
}
