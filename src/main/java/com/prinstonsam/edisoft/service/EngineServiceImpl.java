package com.prinstonsam.edisoft.service;

import com.prinstonsam.edisoft.dao.HibernateEngineDao;
import com.prinstonsam.edisoft.dao.HibernateTypeEngineDao;
import com.prinstonsam.edisoft.model.Body;
import com.prinstonsam.edisoft.model.Engine;
import com.prinstonsam.edisoft.util.ExceptionUtil;
import com.prinstonsam.edisoft.util.NotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class EngineServiceImpl {

    @EJB
    HibernateEngineDao engineDao;

    public Engine create(Engine engine) {
        engineDao.save(engine);
        return engine;
    }

    public void delete(Engine engine) {
        engineDao.delete(engine);
    }

    public Engine getBySerialNumber(String serialNumber) {
        return engineDao.getBySerialNumber(serialNumber);
    }

    public Engine getById(Integer id) {
        Engine  engine = engineDao.getById(id);
        return engine;
    }

    public List<Engine> getAll() {
        return engineDao.getAll();
    }

    public List<Engine> getFreeEngine(){
        return engineDao.getFreeEngine();
    }

    public List<Engine> getPartAll(Integer page, Integer countPerPage) {
        return engineDao.getPartAll(page, countPerPage);
    }

    public void update(Engine engine) throws NotFoundException {
        ExceptionUtil.check(engineDao.save(engine), engine.getId());
    }
}
