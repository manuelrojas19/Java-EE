package com.manuelr.javaee.cdi.producers;

import com.manuelr.javaee.cdi.interfaces.Salute;
import com.manuelr.javaee.cdi.sessionbeans.Police;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

public class LoggerProducer {

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

    // Field Producer
//    @Produces
//    @PersistenceContext
//    EntityManager entityManager;

    // Produces with qualifier
//    @Produces
//    @com.manuelr.javaee.cdi.annotations.Police
//    public Salute getSalute() {
//        return new Police();
//    }
}
