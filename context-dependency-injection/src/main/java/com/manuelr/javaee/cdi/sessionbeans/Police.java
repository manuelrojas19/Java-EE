package com.manuelr.javaee.cdi.sessionbeans;

import com.manuelr.javaee.cdi.annotations.ServiceMan;
import com.manuelr.javaee.cdi.interfaces.Salute;

import javax.ejb.Stateful;
import java.io.Serializable;

@Stateful
@ServiceMan(value = ServiceMan.ServiceType.POLICE)
@com.manuelr.javaee.cdi.annotations.Police
public class Police implements Salute, Serializable {
    @Override
    public String salute(String name) {
        return "Hello citizen!";
    }
}
