package com.sample.contact.server.dao;

import javax.persistence.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zephyr
 * Date: 5/12/11
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasicDAO {

   private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List query(String queryString, final Object... params) {
        Query query = entityManager.createQuery(queryString);
        //setParameters(query, params);
        return query.getResultList();
    }

    public List findAllPerson(){
        return entityManager.createQuery("select p from Person p").getResultList();
    }
}
