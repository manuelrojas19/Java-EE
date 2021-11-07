package com.manuelr.javaee.cdi.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

// custom annotation
public class ScopesBean implements Serializable {
    @Inject
    private RequestScoped requestScoped;

    @Inject
    private Logger logger;

    @PostConstruct
    private void init() {
        logger.log(Level.INFO, "*****************************************");
        logger.log(Level.INFO, "Scopes bean called.");
        logger.log(Level.INFO, "*****************************************");
    }

    @PreDestroy
    private void kill() {
        logger.log(Level.INFO, "*****************************************");
        logger.log(Level.INFO, "Scopes bean gonna be killed.");
        logger.log(Level.INFO, "*****************************************");
    }
}
