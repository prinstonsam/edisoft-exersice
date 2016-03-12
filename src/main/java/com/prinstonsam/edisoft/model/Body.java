package com.prinstonsam.edisoft.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by samsik on 29.02.16.
 */
@Entity
@Table(name = "body")
public class Body {

    public Body() {
    }

    public Body(String vin, String color, Integer countDoors, TypeBody typeBody, Car car) {
        this.vin = vin;
        this.color = color;
        this.countDoors = countDoors;
        this.typeBody = typeBody;
        this.car = car;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "vin", unique = true)
    private String vin;

    @Column(name = "color")
    private String color;

    @Column(name = "count_doors")
    private Integer countDoors;


    @ManyToOne
    @JoinColumn(name = "type_body_id", nullable = true)
    private TypeBody typeBody;

    @OneToOne(mappedBy = "body")
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCountDoors() {
        return countDoors;
    }

    public void setCountDoors(Integer countDoors) {
        this.countDoors = countDoors;
    }

    public TypeBody getTypeBody() {
        return typeBody;
    }

    public void setTypeBody(TypeBody typeBody) {
        this.typeBody = typeBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return Objects.equals(id, body.id) &&
                Objects.equals(vin, body.vin) &&
                Objects.equals(color, body.color) &&
                Objects.equals(countDoors, body.countDoors) &&
                Objects.equals(typeBody, body.typeBody) &&
                Objects.equals(car, body.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vin, color, countDoors, typeBody, car);
    }
}
