package com.prinstonsam.edisoft.service;

import com.prinstonsam.edisoft.dao.HibernateTransmissionDao;
import com.prinstonsam.edisoft.model.Transmission;
import com.prinstonsam.edisoft.util.ExceptionUtil;
import com.prinstonsam.edisoft.util.NotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class TransmissionServiceImpl {
    @EJB
    HibernateTransmissionDao transmissionDao;

    public Transmission create(Transmission transmission) {
        transmissionDao.save(transmission);
        return transmission;
    }

    public void delete(Transmission transmission) {
        transmissionDao.delete(transmission);
    }

    public Transmission getBySerialNumber(String serialNumber) {
        return transmissionDao.getBySerialNumber(serialNumber);
    }

    public Transmission getById(Integer id) {
        Transmission  transmission = transmissionDao.getById(id);
        return transmission;
    }

    public List<Transmission> getAll() {
        return transmissionDao.getAll();
    }

    public List<Transmission> getFreeTransmission(){
        return transmissionDao.getFreeTransmission();
    }

    public List<Transmission> getPartAll(Integer page, Integer countPerPage){
        return transmissionDao.getPartAll(page, countPerPage);
    }

    public void update(Transmission transmission) throws NotFoundException {
        ExceptionUtil.check(transmissionDao.save(transmission), transmission.getId());
    }
}
