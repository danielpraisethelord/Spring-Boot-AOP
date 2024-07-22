package com.springboot.app.springboot_aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * La anotación @EnableAspectJAutoProxy se utiliza en aplicaciones Spring para
 * habilitar el soporte para programación orientada a aspectos (AOP) basada en
 * proxies. Permite que Spring detecte y maneje los aspectos definidos en la
 * aplicación, facilitando la implementación de características transversales
 * como la gestión de transacciones, la seguridad, el registro y más.
 * 
 * Propósito de @EnableAspectJAutoProxy
 * Habilitar AOP: Esta anotación activa el procesamiento de aspectos en la
 * aplicación, permitiendo que los métodos anotados con anotaciones de aspecto
 * (como @Around, @Before, @After, etc.) sean interceptados y manejados por el
 * framework AOP de Spring.
 * Configuración de proxies: Por defecto, se crea un proxy JDK dinámico. Sin
 * embargo, se puede configurar para usar proxies basados en CGLIB estableciendo
 * el atributo proxyTargetClass a true.
 * 
 * Con Spring Boot 3: No es necesario agregar
 * explícitamente @EnableAspectJAutoProxy en la clase principal anotada
 * con @SpringBootApplication, ya que Spring Boot incluye la configuración de
 * AOP automáticamente si detecta que se están utilizando aspectos en la
 * aplicación. Sin embargo, si necesitas configuraciones específicas para AOP
 * (como el uso de proxies CGLIB en lugar de proxies JDK), podrías
 * agregar @EnableAspectJAutoProxy con los parámetros necesarios.
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringbootAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAopApplication.class, args);
	}

}
