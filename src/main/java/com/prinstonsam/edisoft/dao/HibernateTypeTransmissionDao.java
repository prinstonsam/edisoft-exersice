package com.prinstonsam.edisoft.dao;

import com.prinstonsam.edisoft.model.TypeTransmission;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class HibernateTypeTransmissionDao {
    @PersistenceContext(unitName = "MyPostgreDS")
    Session session;

    public Integer save(TypeTransmission value) {
        return (Integer) session.save(value);
    }

    public void delete(TypeTransmission value) {
        session.delete(value);
    }

    public TypeTransmission getByName(String name) {
        Query query = session.createQuery("from TypeTransmission b where b.name = ?");
        query.setParameter(0, name);
        return (TypeTransmission) query.uniqueResult();
    }

    public TypeTransmission getById(Integer id) {
        Query query = session.createQuery("from TypeTransmission t where t.id = ?");
        query.setParameter(0, id);
        return (TypeTransmission) query.uniqueResult();
    }

    public List<TypeTransmission> getAll() {
        Query query = session.createQuery("from TypeTransmission b");
        return query.list();
    }
}
