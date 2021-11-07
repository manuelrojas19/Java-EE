package com.manuelr.javaee.cdi.beans;

import com.manuelr.javaee.cdi.annotations.Police;
import com.manuelr.javaee.cdi.annotations.Soldier;
import com.manuelr.javaee.cdi.interfaces.Salute;

import javax.inject.Inject;
import java.io.Serializable;

/**
 * Example of qualifiers with different annotations
 */
public class QualifierBean implements Serializable {
    @Inject
    @Police
    private Salute policeSalute;

    @Inject
    @Soldier
    private Salute soldierSalute;
}
