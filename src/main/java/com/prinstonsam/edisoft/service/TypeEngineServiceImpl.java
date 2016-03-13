package com.prinstonsam.edisoft.service;

import com.prinstonsam.edisoft.dao.Dao;
import com.prinstonsam.edisoft.dao.HibernateTypeEngineDao;
import com.prinstonsam.edisoft.model.TypeEngine;
import com.prinstonsam.edisoft.util.ExceptionUtil;
import com.prinstonsam.edisoft.util.NotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by samsik on 05.03.16.
 */
@Stateless
public class TypeEngineServiceImpl{

    @EJB
    HibernateTypeEngineDao typeEngineDao;

    public TypeEngine create(TypeEngine type) {
        typeEngineDao.save(type);
        return type;
    }

    public void delete(TypeEngine type) {
        typeEngineDao.delete(type);
    }

    public TypeEngine getByName(String name) {
        return typeEngineDao.getByName(name);
    }

    public TypeEngine getById(Integer id) {
        return typeEngineDao.getById(id);
    }

    public List<TypeEngine> getAll() {
        return typeEngineDao.getAll();
    }

    public void update(TypeEngine type) throws NotFoundException {
        ExceptionUtil.check(typeEngineDao.save(type), type.getId());
    }
}
