package com.curso.spring.plantillaanotaciones;

import config.Configuracion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String... args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Configuracion.class);
        if (args[0].equalsIgnoreCase("-anotaciones")) {
            System.out.println("Hook instalado");
            ((AbstractApplicationContext) ctx).registerShutdownHook();
        }
        System.out.println("Contexto cargado");
        System.out.println(ctx.getBean(beans.Persona.class));
    }
}
