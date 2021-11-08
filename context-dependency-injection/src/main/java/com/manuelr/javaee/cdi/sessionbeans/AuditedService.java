package com.manuelr.javaee.cdi.sessionbeans;

import com.manuelr.javaee.cdi.annotations.Logged;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class AuditedService {
    @Inject
    private Logger logger;

    @PostConstruct
    private void init() {

    }

    @Logged
    public void auditedMethod() {
        logger.log(Level.INFO, "Ok, we are able to call " +
                "this method after call the auditing method from the interceptor");
    }

}
