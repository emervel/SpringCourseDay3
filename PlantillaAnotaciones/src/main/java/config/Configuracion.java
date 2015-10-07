/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import beans.Aficion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import utils.Log;

/**
 *
 * @author Equipo04
 */
@Configuration
@ComponentScan(basePackages = {"beans"})
@PropertySource(value = "props.properties" , name = "propiedades")
public class Configuracion implements Log {
    public Configuracion(){
        log();
    }
    
    /*Para preinstanciar un singleton de la clase que queremos, en nuestro
    caso es un PropertySourcesPlaceholderConfigurer necesario para trabajar con properties.
    Vamos lo que antes se hacía en el xml con <util:properties> */
    @Bean
    public PropertySourcesPlaceholderConfigurer daIgual(){
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    @Bean
    public Aficion daIgualA(){
        return new Aficion();
    }
        @Bean
    public Aficion daIgualB(){
        return new Aficion();
    }
}
