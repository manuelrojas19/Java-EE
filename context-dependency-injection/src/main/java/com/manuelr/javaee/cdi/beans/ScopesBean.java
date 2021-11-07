package com.manuelr.javaee.cdi.beans;

import com.manuelr.javaee.cdi.annotations.Web;
import com.manuelr.javaee.cdi.scopes.ApplicationScope;
import com.manuelr.javaee.cdi.scopes.DependentScope;
import com.manuelr.javaee.cdi.scopes.RequestScope;
import com.manuelr.javaee.cdi.scopes.SessionScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

// custom annotation
@Web
public class ScopesBean implements Serializable {
    @Inject
    private RequestScope requestScoped;

    @Inject
    private DependentScope dependentScope;

    @Inject
    private ApplicationScope applicationScope;

    @Inject
    private SessionScope sessionScope;

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
