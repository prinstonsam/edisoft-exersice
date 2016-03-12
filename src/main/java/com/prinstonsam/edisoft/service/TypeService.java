package com.prinstonsam.edisoft.service;

import com.prinstonsam.edisoft.model.TypeBody;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by samsik on 05.03.16.
 */
//@Local
public interface TypeService<T> {

    public T create(T type);

    public void delete(T type);

    public T getByName(String name);

    public T getById(Integer id);

    public List<T> getAll();
}
