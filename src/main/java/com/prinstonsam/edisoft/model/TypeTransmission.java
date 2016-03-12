package com.prinstonsam.edisoft.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Created by samsik on 29.02.16.
 */
@Entity
@Table(name = "type_transmission")
public class TypeTransmission {
    public TypeTransmission() {
    }

/*    public TypeTransmission(Set<Transmission> transmissions, String name) {
        this.transmissions = transmissions;
        this.name = name;
    }*/

    public TypeTransmission(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;
    @Column(name="name", nullable = false)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringBuffer(String.valueOf(id)).append(":").append(name).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeTransmission that = (TypeTransmission) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
