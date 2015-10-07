/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplotareaplanificada;

import com.curso.beans.ServicioAsincrono;
import com.curso.config.Configuracion;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 *
 * @author usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //solo estamos usando anotaciones
        //en esta clase no hay nada de los metodos planificados porque esos ya los llama spring solito
        //esta clase es para pegarnos con los servicios asincronos
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Configuracion.class);
        System.out.println("Contexto cargado");
        ServicioAsincrono sa = ctx.getBean(ServicioAsincrono.class);
        System.out.println("Hilo principal " + Thread.currentThread());
        
        //Este metodo devuelve void asi que el hilo arranca un nuevo hilo pero continua sin esperar ni ahora ni a un futuro
        sa.metodoUno();
        
        //Este metodo devuelve un futuro, y cuando llamemos a get espera 5 segundos a ver si termina el nuevo hilo
        //Si sobre pasa esos 5 segundos lanza una excepcion
        Future<Double> numero = sa.factorial(100);
        try {
            System.out.println("El factorial es desde un Future:" + numero.get(5L, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Este metodo devuelve un escuchable
        ListenableFuture<Double> valor = sa.factorialLf(100);
        //Al metodo escuchable le añadimos una clase anonima de tipo llamable con dos metodos, uno que se ejecutara cuando acabe con exito
        //y otro si no acaba correctamente
        valor.addCallback(new ListenableFutureCallback<Double>() {

            @Override
            public void onSuccess(Double result) {
                System.out.println("El resultado es desde un ListenableFuture: " + result);
            }

            @Override
            public void onFailure(Throwable ex) {
                LOG.log(Level.SEVERE, "Ha ocurrido un error:", ex);
            }
        });
    }
    private static final Logger LOG = Logger.getLogger(Principal.class.getName());

}

