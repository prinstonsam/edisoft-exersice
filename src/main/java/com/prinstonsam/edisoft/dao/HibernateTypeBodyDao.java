package com.prinstonsam.edisoft.dao;

import com.prinstonsam.edisoft.model.TypeBody;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;


/**
 * Created by samsik on 27.02.16.
 */
@Stateless
public class HibernateTypeBodyDao implements Dao<TypeBody>{

    @PersistenceContext(unitName="MyPostgreDS")
    Session session;

    @Override
    public Integer save(TypeBody value) {
        return (Integer) session.save(value);
    }

    @Override
    public void delete(TypeBody value) {
        session.delete(value);
    }

    @Override
    public TypeBody getByName(String name) {
        Query query = session.createQuery("from TypeBody b where b.name = ?");
        query.setParameter(0, name);
        return (TypeBody) query.uniqueResult();
    }

    @Override
    public TypeBody getById(Integer id) {
        return (TypeBody) session.load(TypeBody.class, id);
    }

    @Override
    public List<TypeBody> getAll() {
        Query query = session.createQuery("from TypeBody b");
        return query.list();
    }

}
