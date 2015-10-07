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
@Component
public class Perfil  implements Log {
    
    @Value("Programador")
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

    @Override
    public String toString() {
        return "Perfil{" + "nombre=" + nombre + '}';
    }
        public Perfil(){
        log();
    }

}
