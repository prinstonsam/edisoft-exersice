package com.prinstonsam.edisoft.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * Created by samsik on 27.02.16.
 */
@Entity
@Table(name = "type_body")
public class TypeBody implements Serializable {
    public TypeBody(){

    }

    public TypeBody(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="name", nullable = false, length = 32)
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
        TypeBody typeBody = (TypeBody) o;
        return Objects.equals(id, typeBody.id) &&
                Objects.equals(name, typeBody.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
