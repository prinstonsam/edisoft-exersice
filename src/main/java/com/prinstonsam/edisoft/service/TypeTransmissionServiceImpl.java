package com.prinstonsam.edisoft.service;

import com.prinstonsam.edisoft.dao.Dao;
import com.prinstonsam.edisoft.dao.HibernateTypeTransmissionDao;
import com.prinstonsam.edisoft.model.TypeEngine;
import com.prinstonsam.edisoft.model.TypeTransmission;
import com.prinstonsam.edisoft.util.ExceptionUtil;
import com.prinstonsam.edisoft.util.NotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by samsik on 05.03.16.
 */
@Stateless
public class TypeTransmissionServiceImpl
//        implements TypeService<TypeTransmission>
{
//    Dao<TypeTransmission> typeTransmissionDao;
    @EJB
    HibernateTypeTransmissionDao typeTransmissionDao;

//    @Override
    public TypeTransmission create(TypeTransmission type) {
        typeTransmissionDao.save(type);
        return type;
    }

//    @Override
    public void delete(TypeTransmission type) {
        typeTransmissionDao.delete(type);
    }

//    @Override
    public TypeTransmission getByName(String name) {
        return typeTransmissionDao.getByName(name);
    }

//    @Override
    public TypeTransmission getById(Integer id) {
        return typeTransmissionDao.getById(id);
    }

//    @Override
    public List<TypeTransmission> getAll() {
        return typeTransmissionDao.getAll();
    }

    public void update(TypeTransmission type) throws NotFoundException {
        ExceptionUtil.check(typeTransmissionDao.save(type), type.getId());
    }
}
