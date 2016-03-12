package com.prinstonsam.edisoft.service;

import com.prinstonsam.edisoft.model.TypeBody;

import javax.ejb.Local;
import java.util.List;

@Local
public interface TypeBodyService {
    public TypeBody create(TypeBody typeBody);

    public void delete(TypeBody typeBody);

    public TypeBody getByName(String name);

    public TypeBody getById(Integer id);

    public List<TypeBody> getAll();

    public void update(TypeBody typeBody);

}
