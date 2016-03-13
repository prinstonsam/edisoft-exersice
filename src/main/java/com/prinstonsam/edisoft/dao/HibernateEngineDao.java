package com.prinstonsam.edisoft.dao;

import com.prinstonsam.edisoft.model.Engine;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class HibernateEngineDao {

    @PersistenceContext(unitName="MyPostgreDS")
    Session session;

    public Integer save(Engine value) {
        return (Integer) session.save(value);
    }

    public void delete(Engine value) {
        session.delete(value);
    }

    public Engine getBySerialNumber(String serialNumber) {
        Query query = session.createQuery("from Engine e where e.serialNumber = ?");
        query.setParameter(0, serialNumber);
        return (Engine) query.uniqueResult();
    }

    public Engine getById(Integer id) {
        Query query = session.createQuery("from Engine e where e.id = ?");
        query.setParameter(0, id);
        return (Engine) query.uniqueResult();
    }

    public List<Engine> getAll() {
        Query query = session.createQuery("from Engine e");
        return query.list();
    }

    public List<Engine> getFreeEngine() {
        return session.createSQLQuery(
                "select * from engine e where not exists (select 1 from car c where e.id=c.engine_id)")
                .addEntity(Engine.class)
                .list();
    }

    public List<Engine> getPartAll(Integer page, Integer countPerPage) {
        return session.createCriteria(Engine.class)
                .setFetchSize(countPerPage)
                .setFirstResult(countPerPage*page)
                .list();
    }
}