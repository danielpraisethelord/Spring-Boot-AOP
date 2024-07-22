# Documentación del Proyecto Spring Boot con AOP

## Descripción del Proyecto

Este proyecto de Spring Boot está diseñado para demostrar el uso de la Programación Orientada a Aspectos (AOP) para interceptar métodos y añadir lógica adicional como registro (logging) y manejo de excepciones. La aplicación incluye un servicio de saludo (GreetingService) que puede ser interceptado por diferentes aspectos para realizar diversas tareas antes, después, o alrededor de la ejecución de sus métodos.

## Definición de AOP

La Programación Orientada a Aspectos (AOP) es un paradigma de programación que permite la separación de preocupaciones transversales (como el logging, la seguridad, la gestión de transacciones, etc.) del código de negocio principal. En AOP, se definen aspectos (aspects) que encapsulan estas preocupaciones transversales. Los aspectos contienen "advice" que se ejecutan en puntos específicos del flujo de ejecución del programa, conocidos como "join points".

## Componentes del Proyecto

### `GreetingAspect.java`

Este aspecto define varios advice que se ejecutan en diferentes puntos de la ejecución de los métodos del servicio de saludo.

- **@Order(2)**: Define la prioridad de ejecución del aspecto. Este aspecto tiene una prioridad más baja que `GreetingFooAspect` (que tiene prioridad 1).
- **@Aspect**: Indica que esta clase es un aspecto.
- **@Component**: Permite que Spring administre esta clase como un componente.

#### Métodos:

- **loggerBefore(JoinPoint joinPoint)**: Advice que se ejecuta antes de los métodos definidos en el pointcut `greetingLoggerPointCut()`. Registra el nombre del método y sus argumentos.
- **loggerAfter(JoinPoint joinPoint)**: Advice que se ejecuta después de los métodos definidos en el pointcut `greetingLoggerPointCut()`. Registra el nombre del método y sus argumentos.
- **loggerAfterReturning(JoinPoint joinPoint)**: Advice que se ejecuta después de que los métodos definidos en el pointcut `greetingLoggerPointCut()` retornan con éxito. Registra el nombre del método y sus argumentos.
- **loggerAfterThrowing(JoinPoint joinPoint)**: Advice que se ejecuta después de que los métodos definidos en el pointcut `greetingLoggerPointCut()` lanzan una excepción. Registra el nombre del método y sus argumentos.
- **loggerAround(ProceedingJoinPoint joinPoint)**: Advice que envuelve la ejecución de los métodos definidos en el pointcut `greetingLoggerPointCut()`. Registra el nombre del método y sus argumentos antes y después de la ejecución del método, y maneja cualquier excepción lanzada.

### `GreetingFooAspect.java`

Este aspecto define advice adicionales que también se ejecutan antes y después de los métodos del servicio de saludo.

- **@Order(1)**: Define la prioridad de ejecución del aspecto. Este aspecto tiene la prioridad más alta, por lo que se ejecuta antes que `GreetingAspect`.
- **@Aspect**: Indica que esta clase es un aspecto.
- **@Component**: Permite que Spring administre esta clase como un componente.

#### Métodos:

- **loggerBefore(JoinPoint joinPoint)**: Advice que se ejecuta antes de los métodos definidos en el pointcut `greetingFooLoggerPointCut()`. Registra el nombre del método y sus argumentos.
- **loggerAfter(JoinPoint joinPoint)**: Advice que se ejecuta después de los métodos definidos en el pointcut `greetingFooLoggerPointCut()`. Registra el nombre del método y sus argumentos.

### `GreetingServicePointcuts.java`

Esta clase define los pointcuts utilizados por los aspectos para identificar los métodos a interceptar.

- **@Aspect**: Indica que esta clase define pointcuts.
- **@Component**: Permite que Spring administre esta clase como un componente.

#### Métodos:

- **greetingLoggerPointCut()**: Define un pointcut que coincide con todos los métodos en cualquier clase dentro del paquete `com.springboot.app.springboot_aop.services` que retornan un String.
- **greetingFooLoggerPointCut()**: Define un pointcut idéntico a `greetingLoggerPointCut()` para demostrar cómo múltiples aspectos pueden compartir los mismos pointcuts.

### `GreetingController.java`

Este controlador expone dos endpoints para probar el servicio de saludo.

- **@RestController**: Indica que esta clase es un controlador de Spring MVC.
- **@Autowired**: Inyecta una instancia de `GreetingService`.

#### Métodos:

- **greeting()**: Endpoint que llama al método `sayHello` de `GreetingService` y retorna el resultado.
- **greetingError()**: Endpoint que llama al método `sayHelloThrowAnError` de `GreetingService` y maneja la excepción lanzada.

### `GreetingService.java`

Interfaz que define los métodos del servicio de saludo.

#### Métodos:

- **sayHello(String person, String phrase)**: Devuelve un saludo concatenando la frase y el nombre de la persona.
- **sayHelloThrowAnError(String person, String phrase)**: Lanza una excepción simulada.

### `GreetingServiceImpl.java`

Implementación del servicio de saludo.

- **@Service**: Indica que esta clase es un servicio administrado por Spring.

#### Métodos:

- **sayHello(String person, String phrase)**: Implementa el método de la interfaz para devolver un saludo.
- **sayHelloThrowAnError(String person, String phrase)**: Implementa el método de la interfaz para lanzar una excepción simulada.

### `SpringbootAopApplication.java`

Clase principal que arranca la aplicación Spring Boot.

- **@EnableAspectJAutoProxy**: Habilita el soporte para AOP basado en proxies en la aplicación Spring.
- **@SpringBootApplication**: Indica que esta es una aplicación Spring Boot.

## Relación entre las Clases

- **GreetingController**: Depende de `GreetingService` para manejar solicitudes HTTP y retornar respuestas.
- **GreetingService**: Define la interfaz del servicio de saludo, implementada por `GreetingServiceImpl`.
- **GreetingServiceImpl**: Proporciona la implementación concreta de los métodos definidos en `GreetingService`.
- **GreetingAspect y GreetingFooAspect**: Contienen lógica transversal que se aplica a los métodos de `GreetingServiceImpl` definidos por los pointcuts en `GreetingServicePointcuts`.

## Funcionamiento de la Aplicación

Cuando se realiza una solicitud HTTP a los endpoints `/greeting` o `/greeting-error`, el controlador `GreetingController` invoca los métodos correspondientes de `GreetingServiceImpl`. Antes, después y alrededor de la ejecución de estos métodos, los aspectos `GreetingAspect` y `GreetingFooAspect` interceptan las llamadas y ejecutan lógica adicional (registro, manejo de excepciones, etc.) definida en sus respectivos advice. Esto demuestra cómo AOP puede separar y modularizar preocupaciones transversales del código de negocio principal, mejorando la mantenibilidad y claridad del código.
