package com.example.apaqtech.manage.dao;

import com.example.apaqtech.manage.pojo.Admin;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

//@Transactional
//public class AdminJpaRepo implements AdminRepo {
//
//    @PersistenceContext
//    EntityManager em;
//
//    @Override
//    public List<Admin> findAll() {
//        Query query = em.createQuery("select * from Admin");
//        return query.getResultList();
//    }
//
//    @Override
//    public void save(Admin admin) {
//        em.persist(admin);
//    }
//}
