package com.prinstonsam.edisoft.service;

import com.prinstonsam.edisoft.dao.HIbernateCarDao;
import com.prinstonsam.edisoft.model.Car;
import com.prinstonsam.edisoft.util.ExceptionUtil;
import com.prinstonsam.edisoft.util.NotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CarServiceImpl {

    @EJB
    HIbernateCarDao carDao;

    public Car create(Car car) {
        carDao.save(car);
        return car;
    }

    public void delete(Car car) {
        carDao.delete(car);
    }

    public Car getBySerialNumber(String serialNumber) {
        return carDao.getBySerialNumber(serialNumber);
    }

    public Car getById(Integer id) {
        Car  car = carDao.getById(id);
        return car;
    }

    public List<Car> getAll() {
        return carDao.getAll();
    }

    public List<Car> getPartAll(Integer page, Integer countPerPage){
        return carDao.getPartAll(page, countPerPage);
    }

    public void update(Car car) throws NotFoundException {
        ExceptionUtil.check(carDao.save(car), car.getId());
    }
}

