/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import utils.Log;

/**
 *
 * @author usuario
 */
@Component
public class Persona  implements Log {
    
    //@Value("#{propiedades.nombrePersona}")
    //@Value("${propiedades.nombrePersona}")    
    @Value("${nombrePersona}")
    private String nombre;

    @Resource
    private Perfil perfil;

    @Autowired
    private List<Aficion> aficiones;

    /**
     * Get the value of aficiones
     *
     * @return the value of aficiones
     */
    public List<Aficion> getAficiones() {
        return aficiones;
    }

    /**
     * Set the value of aficiones
     *
     * @param aficiones new value of aficiones
     */
    public void setAficiones(List<Aficion> aficiones) {
        this.aficiones = aficiones;
    }

    /**
     * Get the value of perfil
     *
     * @return the value of perfil
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * Set the value of perfil
     *
     * @param perfil new value of perfil
     */
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

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
        return "Persona{" + "nombre=" + nombre + ", perfil=" + perfil + ", aficiones=" + aficiones + '}';
    }

        public Persona(){
        log();
    }
}
