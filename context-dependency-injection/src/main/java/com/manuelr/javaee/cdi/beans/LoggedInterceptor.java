package com.manuelr.javaee.cdi.beans;

import com.manuelr.javaee.cdi.annotations.Logged;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

@Logged
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class LoggedInterceptor {
    @Inject
    private Logger logger;

    private String user = "Manuel";

    @AroundInvoke
    public Object logMethodCall(InvocationContext context) throws Exception {
        logger.log(Level.INFO, "User {} invoked {1} method at {2}", new Object[]
                {user, context.getMethod().getName(), LocalDate.now()});
        return context.proceed();
    }
}
