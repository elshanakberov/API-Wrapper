package com.rabitabank.apiwrapper.dao;

import com.rabitabank.apiwrapper.entity.Call;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class CallDaoHibernateImpl implements CallDao{

    private EntityManager entityManager;
    @Autowired
    public CallDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Call call) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(call);
    }
}
