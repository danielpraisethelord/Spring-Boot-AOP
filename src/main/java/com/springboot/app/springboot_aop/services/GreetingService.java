package com.springboot.app.springboot_aop.services;

public interface GreetingService {
    String sayHello(String person, String phrase);

    String sayHelloThrowAnError(String person, String phrase);
}
