package com.prinstonsam.edisoft.dao;

import com.prinstonsam.edisoft.model.TypeBody;
import com.prinstonsam.edisoft.model.TypeEngine;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class HibernateTypeEngineDao
{
    @PersistenceContext(unitName = "MyPostgreDS")
    Session session;

    public Integer save(TypeEngine value) {
        return (Integer) session.save(value);
    }

    public void delete(TypeEngine value) {
        session.delete(value);
    }

    public TypeEngine getByName(String name) {
        Query query = session.createQuery("from TypeEngine b where b.name = ?");
        query.setParameter(0, name);
        return (TypeEngine) query.uniqueResult();
    }

    public TypeEngine getById(Integer id) {
        Query query = session.createQuery("from TypeEngine e where e.id = ?");
        query.setParameter(0, id);
        return (TypeEngine) query.uniqueResult();
    }

    public List<TypeEngine> getAll() {
        Query query = session.createQuery("from TypeEngine b");
        return query.list();
    }
}
