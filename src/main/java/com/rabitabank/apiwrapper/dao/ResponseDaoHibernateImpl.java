package com.rabitabank.apiwrapper.dao;

import com.rabitabank.apiwrapper.entity.Response;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ResponseDaoHibernateImpl implements ResponseDao{

    private EntityManager entityManager;

    @Autowired
    public ResponseDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Response response) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(response);
    }
}
