/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.beans;

import java.util.concurrent.Future;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 *
 * @author usuario
 */
@Service
public class ServicioAsincrono {

    //Este metodo será llamado en paralelo cuando spring lo invoque. Al no devolver no hay problema de concurrencia
    @Async
    public void metodoUno() {
        System.out.println("En metodoUno de " + getClass().getName() + " en el hilo " + Thread.currentThread());
    }

    //Este metodo asincrono devuelve un valor de inmediato que es un "futuro" que es una interfaz que algún momento 
    //tendra el resultado de la computación del metodo y hemos dejado que el hilo principal continue sin tener que esperar el valor
    //El objeto no tiene por qué ser un Double, puede ser cualquier tipo de objeto
    //El objeto Future tiene el metodo isDone() que devolvera un true cuando haya acabado
    //El objeto Future tb tiene el metodo get() que si no ha acabado parará el hilo principal hasta que finalice el metodo asincrono
    @Async
    public Future<Double> factorial(Integer numero) {
        System.out.println("En factorial de " + getClass().getName() + " en el hilo " + Thread.currentThread());
        return new AsyncResult<>(factorialUtil(numero));
    }

    @Async
    public ListenableFuture<Double> factorialLf(Integer numero) {
        System.out.println("En factorial de " + getClass().getName() + " en el hilo " + Thread.currentThread());
        return new AsyncResult<>(factorialUtil(numero));
    }

    private Double factorialUtil(Integer numero) {
        if (numero <= 1) {
            return 1.0;
        } else {
            return numero * factorialUtil(numero - 1);
        }
    }
}
