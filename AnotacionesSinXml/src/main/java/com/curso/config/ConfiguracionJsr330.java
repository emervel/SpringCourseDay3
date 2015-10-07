/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.config;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author usuario
 */
@Configuration //Para indicar que es un clase de configuracion
@ComponentScan(basePackages = "com.curso.jsr330") //Para indicar que active las anotaciones en el paquete com.curso.jsr330
public class ConfiguracionJsr330 implements Util {

    /*autocablea el único applicationctx que hay para que nuestra clase tenga una dependencia
    del aplicationcontext de modo que luego podamos en tiempo de ejecucion coger la clase 
    que necesitemos de ese contexto ctx.getBean(A.class). Así tenemos un cajon del cual poder
    coger nuestras clases en vez de tener que anotar con @Bean todas mis clases*/
    @Autowired 
    private ApplicationContext ctx;

    public ConfiguracionJsr330() {
        log();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println(ctx);
    }
}
