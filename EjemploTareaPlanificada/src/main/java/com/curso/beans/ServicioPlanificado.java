/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.beans;

import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class ServicioPlanificado {

    //a partir de ahora mientras la aplicación se este ejecutando Spring llamará automáticamente a los metodos Scheduled
    
    //Este se ejecuta cada 5 segundos
    @Scheduled(fixedRate = 5000)
    public void fixedRate() {
        System.out.println("En fixed rate. Son las " + new Date());
    }

    //Una vez que Spring llame a este metodo, Spring debe esperar 7 segundos hasta que lo pueda volver a llamar
    @Scheduled(fixedDelay = 7000)
    public void fixedDelay() {
        System.out.println("En fixed delay. Son las " + new Date());
    }

    //Spring ejecutara este metodo cada 3 segundos. Usa la expresion cron
    @Scheduled(cron = "*/3 * * * * ?")
    public void cron() {
        System.out.println("En cron. Son las " + new Date());
    }
}
