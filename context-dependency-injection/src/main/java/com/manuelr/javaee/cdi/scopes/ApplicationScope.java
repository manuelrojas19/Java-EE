package com.manuelr.javaee.cdi.scopes;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@ApplicationScoped
public class ApplicationScope implements Serializable {
    private static final long serialVersionUID = 8017148225587596226L;

    public String getHashCode() {
        return this.hashCode() + "";
    }
}

