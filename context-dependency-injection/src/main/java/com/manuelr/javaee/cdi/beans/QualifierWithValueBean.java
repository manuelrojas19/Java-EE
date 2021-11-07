package com.manuelr.javaee.cdi.beans;

import com.manuelr.javaee.cdi.annotations.ServiceMan;
import com.manuelr.javaee.cdi.annotations.Web;
import com.manuelr.javaee.cdi.interfaces.Salute;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Example of qualifiers with values in a single annotation
 */
@Web
public class QualifierWithValueBean implements Serializable {
    @Inject
    @ServiceMan(value = ServiceMan.ServiceType.POLICE)
    private Salute policeSalute;

    @Inject
    @ServiceMan(value = ServiceMan.ServiceType.SOLDIER)
    private Salute soldierSalute;
}
