package com.prinstonsam.edisoft.service;

import com.prinstonsam.edisoft.dao.HibernateBodyDao;
import com.prinstonsam.edisoft.model.Body;
import com.prinstonsam.edisoft.util.ExceptionUtil;
import com.prinstonsam.edisoft.util.NotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class BodyServiceImpl {
    @EJB
    HibernateBodyDao bodyDao;

    public Body create(Body body) {
        bodyDao.save(body);
        return body;
    }

    public void delete(Body body) {
        bodyDao.delete(body);
    }

    public Body getByVin(String vin) {
        return bodyDao.getByVin(vin);
    }

    public Body getById(Integer id) {
        Body  body = bodyDao.getById(id);
        return body;
    }

    public List<Body> getAll() {
        return bodyDao.getAll();
    }

    public List<Body> getFreeBody(){
        return bodyDao.getFreeBody();
    }

    public List<Body> getPartAll(Integer page, Integer countPerPage){
        return bodyDao.getPartAll(page, countPerPage);
    }

    public void update(Body body) throws NotFoundException {
        ExceptionUtil.check(bodyDao.save(body), body.getId());
    }

}
