package com.prinstonsam.edisoft.dao;

import com.prinstonsam.edisoft.model.TypeBody;

import java.util.List;

/**
 * Created by samsik on 29.02.16.
 */
public interface Dao <T> {
    public Integer save(T value);

    public void delete(T value);

    public T getByName(String name);

    public T getById(Integer id);

    public List<T> getAll();
}
