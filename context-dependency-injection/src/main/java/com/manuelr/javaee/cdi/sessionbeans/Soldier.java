package com.manuelr.javaee.cdi.sessionbeans;

import com.manuelr.javaee.cdi.annotations.ServiceMan;
import com.manuelr.javaee.cdi.interfaces.Salute;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
@ServiceMan(value = ServiceMan.ServiceType.SOLDIER)
@com.manuelr.javaee.cdi.annotations.Soldier
public class Soldier implements Salute, Serializable {
    @Override
    public String salute(String name) {
        return "Yes sir!";
    }
}
