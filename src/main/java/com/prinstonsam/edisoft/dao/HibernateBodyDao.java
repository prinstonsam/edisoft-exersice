package com.prinstonsam.edisoft.dao;

import com.prinstonsam.edisoft.model.Body;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class HibernateBodyDao {
    @PersistenceContext(unitName="MyPostgreDS")
    Session session;

    public Integer save(Body value) {
        return (Integer) session.save(value);
    }

    public void delete(Body value) {
        session.delete(value);
    }

    public Body getByVin(String vin) {
        Query query = session.createQuery("from Body b where b.vin = ?");
        query.setParameter(0, vin);
        return (Body) query.uniqueResult();
    }

    public Body getById(Integer id) {
        Query query = session.createQuery("from Body b where b.id = ?");
        query.setParameter(0, id);
        return (Body) query.uniqueResult();
    }

    public List<Body> getAll() {
        return session.createCriteria(Body.class).list();
    }

    public List<Body> getFreeBody(){
        Query query = session.createSQLQuery(
                "select * from body b where not exists (select 1 from car c where b.id=c.body_id)")
                .addEntity(Body.class);
        return query.list();
    }

    public List<Body> getPartAll(Integer page, Integer countPerPage){
        return session.createCriteria(Body.class)
                .setFetchSize(countPerPage)
                .setFirstResult(countPerPage*page)
                .list();
    }
}
