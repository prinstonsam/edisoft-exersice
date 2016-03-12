package com.prinstonsam.edisoft.dao;

import com.prinstonsam.edisoft.model.Body;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class HibernateBodyDao {
    @PersistenceContext(unitName="MyPostgreDS")
    Session session;

//    @Override
    public Integer save(Body value) {
        return (Integer) session.save(value);
    }

//    @Override
    public void delete(Body value) {
        session.delete(value);
    }

//    @Override
    public Body getByVin(String vin) {
        Query query = session.createQuery("from Body b where b.vin = ?");
        query.setParameter(0, vin);
        return (Body) query.uniqueResult();
    }

//    @Override
    public Body getById(Integer id) {
        return (Body) session.load(Body.class, id);
    }

//    @Override
    public List<Body> getAll() {


//        Query query = session.createQuery("from Body b");
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
