package com.manuelr.javaee.cdi.scopes;

public class DependentScope {

    public String getHashCode() {
        return this.hashCode() + "";
    }
}
