package com.prinstonsam.edisoft.dao;

import com.prinstonsam.edisoft.model.TypeBody;
import com.prinstonsam.edisoft.model.TypeEngine;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by samsik on 05.03.16.
 */
@Stateless
public class HibernateTypeEngineDao
//        implements Dao<TypeEngine>
{

    @PersistenceContext(unitName = "MyPostgreDS")
    Session session;

//    @Override
    public Integer save(TypeEngine value) {
        return (Integer) session.save(value);
    }

//    @Override
    public void delete(TypeEngine value) {
        session.delete(value);
    }

//    @Override
    public TypeEngine getByName(String name) {
        Query query = session.createQuery("from TypeEngine b where b.name = ?");
        query.setParameter(0, name);
        return (TypeEngine) query.uniqueResult();
    }

//    @Override
    public TypeEngine getById(Integer id) {
        return (TypeEngine) session.load(TypeEngine.class, id);
    }

//    @Override
    public List<TypeEngine> getAll() {
        Query query = session.createQuery("from TypeEngine b");
        return query.list();
    }
}
