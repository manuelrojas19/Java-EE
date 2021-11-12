package com.manuelr.javaee.jpa.service;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Singleton
@Startup
public class PersistenceService {

    @Inject
    EntityManager entityManager;
}
