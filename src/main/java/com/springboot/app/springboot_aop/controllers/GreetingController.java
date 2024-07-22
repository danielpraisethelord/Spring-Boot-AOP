package com.springboot.app.springboot_aop.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.springboot_aop.services.GreetingService;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    /*
     * Cuando se invoca el método sayHello(..) en el controlador, como se intercepta
     * antes, se va a ejecutar el aspecto (GreetingAspect) primero, y todo dentro
     * del método loggerBefore y va a mostrar el logger en consola primero, después
     * de finaliar eso va a ejecutar el método sayHello de GreetingService
     * implementado por GreetingServiceImpl y va a imprimier el menesaje en consola
     * después (al final)
     */
    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {

        return ResponseEntity
                .ok(Collections.singletonMap("greeting", greetingService.sayHello("Daniel", "Hola que tal!")));
    }

    @GetMapping("/greeting-error")
    public ResponseEntity<?> greetingError() {

        return ResponseEntity
                .ok(Collections.singletonMap("greeting",
                        greetingService.sayHelloThrowAnError("Daniel", "Hola que tal!")));
    }
}
