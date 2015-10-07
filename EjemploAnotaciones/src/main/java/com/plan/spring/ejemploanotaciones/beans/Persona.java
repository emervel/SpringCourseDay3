/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.spring.ejemploanotaciones.beans;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author usuario
 */
@Component
public class Persona {

    private Aficion aficion;

    private Perfil perfil;

    @Override
    public String toString() {
        return "Persona{" + "aficion=" + aficion + ", perfil=" + perfil + '}';
    }

    @Resource
    private void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Autowired
    private void setAficion(Aficion aficion) {
        this.aficion = aficion;
    }
}
