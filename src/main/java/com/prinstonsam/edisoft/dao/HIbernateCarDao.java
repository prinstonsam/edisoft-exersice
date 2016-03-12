package com.prinstonsam.edisoft.dao;

import javax.ejb.Stateless;

import com.prinstonsam.edisoft.model.Car;
import org.hibernate.Query;
import org.hibernate.Session;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class HIbernateCarDao {

    @PersistenceContext(unitName="MyPostgreDS")
    Session session;

    //    @Override
    public Integer save(Car value) {
        return (Integer) session.save(value);
    }

    //    @Override
    public void delete(Car value) {
        session.delete(value);
    }

    //    @Override
    public Car getBySerialNumber(String serialNumber) {
        Query query = session.createQuery("from Car c where c.serialNumber = ?");
        query.setParameter(0, serialNumber);
        return (Car) query.uniqueResult();
    }

    //    @Override
    public Car getById(Integer id) {
        return (Car) session.load(Car.class, id);
    }

    //    @Override
    public List<Car> getAll() {
        Query query = session.createQuery("from Car c");
        return query.list();
    }

    public List<Car> getPartAll(Integer page, Integer countPerPage) {
        return session.createCriteria(Car.class)
                .setFetchSize(countPerPage)
                .setFirstResult(countPerPage*page)
                .list();
    }
}
