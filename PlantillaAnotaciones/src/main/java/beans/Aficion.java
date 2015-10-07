/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import utils.Log;

/**
 *
 * @author usuario
 */
public class Aficion implements Log  {
    
    @Value("Baloncesto")
    private String nombre;

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Aficion(){
        log();
    }
}
