package com.manuelr.javaee.cdi.beans;

import com.manuelr.javaee.cdi.annotations.Web;
import com.manuelr.javaee.cdi.scopes.ApplicationScope;
import com.manuelr.javaee.cdi.scopes.DependentScope;
import com.manuelr.javaee.cdi.scopes.RequestScope;
import com.manuelr.javaee.cdi.scopes.SessionScope;
import com.manuelr.javaee.cdi.sessionbeans.AuditedService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Inject
    private AuditedService auditedService;

    @PostConstruct
    private void init() {
        auditedService.auditedMethod();
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
