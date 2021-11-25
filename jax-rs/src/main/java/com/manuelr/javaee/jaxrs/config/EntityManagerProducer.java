package com.manuelr.javaee.jaxrs.config;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerProducer {

    @Produces
    public EntityManager entityManager() {
        return Persistence
                .createEntityManagerFactory("pu")
                .createEntityManager();
    }
}
