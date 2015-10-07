/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.curso.config;

import com.curso.beans.Persona;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *
 * @author usuario
 */
@Configuration //Para identificar que la clase es de configuración
@ComponentScan(basePackages = {"com.curso.componentes","com.curso.beans"})
@PropertySource("props.properties")
public class Configuracion implements Util{

    public Configuracion() {
        log();
    }
    
    /*Para preinstanciar un singleton de la clase que queremos, en nuestro
    caso es un PropertySourcesPlaceholderConfigurer necesario para trabajar con properties.
    Vamos lo que antes se hacía en el xml con <util:properties> */
    @Bean
    public PropertySourcesPlaceholderConfigurer daIgual(){
        /*los nombres de los metodos dan igual porque lo que interesa es que estos metodos creen los
        objetos que luego necesitaremos (que me instancie los beans)
        */
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Bean(autowire = Autowire.BY_TYPE)
    @Scope("prototype")
    public Persona tambienDaIgual(){
        return new Persona();
    }
}
