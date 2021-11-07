package com.manuelr.javaee.cdi.scopes;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class SessionScope implements Serializable {
    private static final long serialVersionUID = 4786685796444037917L;

    public String getHashCode() {
        return this.hashCode() + "";
    }
}
