/*
 * Spring permite planificar la ejecución de metodos para que se ejecuten en un determinado momento
 */

package com.curso.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author usuario
 */
@Configuration
@EnableScheduling //Habilita la planificación de metodos
@EnableAsync //Habilita la ejecución de metodos de forma asincrona (fuera del hilo principal)
@ComponentScan("com.curso.beans")
public class Configuracion {
    
}
