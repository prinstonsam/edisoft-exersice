package com.prinstonsam.edisoft.service;

import com.prinstonsam.edisoft.dao.Dao;
import com.prinstonsam.edisoft.model.TypeBody;
import com.prinstonsam.edisoft.util.ExceptionUtil;
import com.prinstonsam.edisoft.util.NotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by samsik on 27.02.16.
 */
@Stateless
public class TypeBodyServiceImpl
//        implements TypeBodyService
{

    @EJB
    Dao<TypeBody> typeBodyDao;

    public TypeBody create(TypeBody typeBody) {
        typeBodyDao.save(typeBody);
        return typeBody;
    }

    public void delete(TypeBody typeBody) {
        typeBodyDao.delete(typeBody);
    }

    public TypeBody getByName(String name) {
        return typeBodyDao.getByName(name);
    }

    public TypeBody getById(Integer id) {
        TypeBody  typeBody = typeBodyDao.getById(id);
        return typeBody;
    }

    public List<TypeBody> getAll() {
        return typeBodyDao.getAll();
    }

    public void update(TypeBody typeBody) throws NotFoundException {
        ExceptionUtil.check(typeBodyDao.save(typeBody), typeBody.getId());
    }
}
