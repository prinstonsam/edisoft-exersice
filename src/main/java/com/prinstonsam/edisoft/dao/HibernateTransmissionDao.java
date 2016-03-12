package com.prinstonsam.edisoft.dao;

import com.prinstonsam.edisoft.model.Transmission;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class HibernateTransmissionDao {

    @PersistenceContext(unitName="MyPostgreDS")
    Session session;

    //    @Override
    public Integer save(Transmission value) {
        return (Integer) session.save(value);
    }

    //    @Override
    public void delete(Transmission value) {
        session.delete(value);
    }

    //    @Override
    public Transmission getBySerialNumber(String serialNumber) {
        Query query = session.createQuery("from Transmission t where t.serialNumber = ?");
        query.setParameter(0, serialNumber);
        return (Transmission) query.uniqueResult();
    }

    //    @Override
    public Transmission getById(Integer id) {
        return (Transmission) session.load(Transmission.class, id);
    }

    //    @Override
    public List<Transmission> getAll() {
        Query query = session.createQuery("from Transmission t");
        return query.list();
    }

    public List<Transmission> getFreeTransmission() {
        return session.createSQLQuery(
                "select * from transmission t where not exists (select 1 from car c where t.id=c.transmission_id)")
                .addEntity(Transmission.class)
                .list();
    }

    public List<Transmission> getPartAll(Integer page, Integer countPerPage) {
        return session.createCriteria(Transmission.class)
                .setFetchSize(countPerPage)
                .setFirstResult(countPerPage*page)
                .list();
    }
}
