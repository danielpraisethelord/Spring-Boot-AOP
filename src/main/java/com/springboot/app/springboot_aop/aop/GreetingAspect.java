package com.springboot.app.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * La anotación @Order en Spring se utiliza para definir el orden de ejecución
 * de los aspectos (advice) o de los componentes (beans). Cuando se tienen
 * múltiples aspectos o beans que pueden aplicarse a un punto de ejecución o que
 * deben ser cargados en un orden específico, @Order asegura que se sigan las
 * prioridades definidas.
 * 
 * Propósito de @Order
 * Controlar el orden de ejecución de aspectos: Cuando hay múltiples aspectos
 * aplicables a un punto de ejecución, @Order define en qué orden se deben
 * aplicar.
 * Priorizar la inicialización de beans: En el contexto de Spring IoC (Inversion
 * of Control), @Order se puede usar para especificar el orden en que se
 * inicializan los beans.
 * Uso de @Order
 * Valores de orden: @Order toma un valor entero. Un valor más bajo indica una
 * mayor prioridad (se ejecuta primero), y un valor más alto indica una menor
 * prioridad (se ejecuta después).
 * Aplicación en aspectos: Se usa junto con la anotación @Aspect para definir el
 * orden de los aspectos.
 * 
 * La anotación @Order en Spring es una herramienta útil para definir el orden
 * de ejecución de aspectos y la inicialización de beans. En el contexto de
 * aspectos, permite controlar en qué orden se aplican los aspectos cuando hay
 * múltiples aspectos aplicables a un punto de ejecución. En el contexto de
 * beans, asegura que los beans se inicialicen en un orden específico, lo cual
 * puede ser crucial para la configuración adecuada de una aplicación Spring.
 */
@Order(2)
/**
 * La anotación @Aspect en Spring se utiliza para definir una clase como un
 * aspecto (aspect) en la programación orientada a aspectos (AOP). Un aspecto en
 * AOP es un módulo que encapsula un comportamiento que afecta a múltiples
 * clases en una aplicación, lo que permite la separación de preocupaciones
 * transversales como el logging, la gestión de transacciones, la seguridad,
 * etc.
 * 
 * Propósito de @Aspect
 * Definir Aspectos: Indica que la clase anotada contiene definiciones de
 * aspectos.
 * Contener Advice: Permite definir métodos con lógica de "advice" que se
 * ejecutarán en momentos específicos en el ciclo de vida de la ejecución del
 * programa (como antes, después o alrededor de la ejecución de métodos
 * objetivo).
 * Definir Pointcuts: Utiliza expresiones pointcut para indicar los puntos de
 * unión (join points) donde se debe aplicar el advice.
 * 
 * La anotación @Aspect en Spring se utiliza para marcar una clase como un
 * aspecto, permitiendo la definición de pointcuts y advice para aplicar
 * comportamiento transversal en una aplicación. Es una parte fundamental de la
 * implementación de AOP en Spring, proporcionando una forma de modularizar
 * preocupaciones transversales.
 */
@Aspect
/*
 * Para que la anotación @Aspect se pueda ejecutar en Spring Boot e interceptar
 * los métodos, la clase se tiene que anotar con @Component
 */
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /*
     * En la programación orientada a aspectos (AOP) con Spring, la interfaz
     * JoinPoint de org.aspectj.lang.JoinPoint proporciona una representación del
     * punto en el flujo de ejecución de un programa donde se puede aplicar un
     * aspecto. Específicamente, un JoinPoint es un punto bien definido durante la
     * ejecución del programa, como la llamada a un método, la ejecución de un
     * método, la construcción de un objeto, etc.
     * 
     * Propósito de JoinPoint
     * JoinPoint se utiliza dentro de los métodos de advice para obtener detalles
     * sobre la ubicación y el contexto del punto de ejecución donde se aplica el
     * aspecto. Esto incluye información sobre:
     * 
     * El método objetivo que se está interceptando.
     * Los argumentos del método.
     * El objeto que posee el método interceptado.
     * La firma del método.
     * 
     * La interfaz JoinPoint en AOP con Spring es fundamental para obtener detalles
     * sobre el contexto del punto de ejecución donde se aplica el aspecto.
     * Proporciona información detallada sobre el método objetivo, sus argumentos y
     * el objeto sobre el que se ejecuta, permitiendo a los desarrolladores
     * implementar lógica transversal más rica y contextualizada.
     */

    /*
     * La anotación @Before en Spring AOP se utiliza para definir un "advice" que
     * debe ejecutarse antes de la ejecución de un método coincidente. El advice es
     * un fragmento de código que se ejecuta en un punto específico de la ejecución
     * del programa, y se define junto con una expresión "pointcut" que especifica
     * los métodos a los que se aplica.
     * 
     * Propósito de @Before
     * Ejecutar código antes de un método específico: Permite ejecutar código antes
     * de la ejecución del método que coincide con la expresión del pointcut.
     * Realizar tareas previas: Puede ser utilizado para diversas tareas como
     * registro (logging), validación de parámetros, verificación de seguridad,
     * etc., antes de que el método principal sea ejecutado.
     * Explicación de la expresión
     * La expresión @Before("execution(String GreetingService.sayHello(..))") se
     * desglosa de la siguiente manera:
     * 
     * execution(...): Es una sintaxis de AspectJ utilizada para definir un pointcut
     * basado en la ejecución de métodos.
     * String: Especifica el tipo de retorno del método. En este caso, el método
     * debe retornar un String.
     * GreetingService: Especifica la clase que contiene el método.
     * sayHello: Especifica el nombre del método que queremos interceptar.
     * (..): Indica que el método puede tener cualquier número y tipo de argumentos.
     * 
     * Explicación del ejemplo
     * GreetingService: Es un simple servicio que tiene un método sayHello que toma
     * un String como parámetro y devuelve un saludo.
     * LoggingAspect: Define un aspecto con un advice que se ejecuta antes del
     * método sayHello en GreetingService. El advice utiliza @Before con la
     * expresión execution(String GreetingService.sayHello(..)) para interceptar
     * todas las llamadas a este método. En el método logBeforeMethodExecution, se
     * registra el nombre del método y sus argumentos antes de su ejecución.
     * Configuración principal de Spring Boot: Se configura una aplicación Spring
     * Boot que registra GreetingService como un bean para que pueda ser inyectado y
     * utilizado en la aplicación.
     * Ejecución
     * Cuando el método sayHello de GreetingService es llamado, el advice en
     * LoggingAspect se ejecuta primero, imprimiendo el nombre del método y sus
     * argumentos antes de que sayHello ejecute su lógica.
     * 
     * Este patrón es útil para separar preocupaciones transversales como el
     * registro (logging) del código de negocio principal, mejorando así la
     * mantenibilidad y la claridad del código.
     */

    @Before("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los argumentos " + args);
    }

    /*
     * La anotación @After en Spring AOP se utiliza para definir un "advice" que se
     * ejecutará después de que un método coincidente haya sido ejecutado,
     * independientemente de si el método completó con éxito o lanzó una excepción.
     * Esta anotación es útil para realizar tareas de limpieza, registrar la
     * finalización de la ejecución de métodos, entre otros.
     * 
     * Propósito de @After
     * Ejecutar código después de un método específico: Permite ejecutar código
     * después de la ejecución del método que coincide con la expresión del
     * pointcut.
     * Realizar tareas posteriores: Puede ser utilizado para diversas tareas como
     * registro (logging), limpieza de recursos, auditoría, etc., después de que el
     * método principal haya sido ejecutado.
     * Explicación de la expresión
     * La
     * expresión @After("execution(String com.app.springboot_aop.services.GreetingService.*(..))"
     * ) se desglosa de la siguiente manera:
     * 
     * execution(...): Es una sintaxis de AspectJ utilizada para definir un pointcut
     * basado en la ejecución de métodos.
     * String: Especifica el tipo de retorno del método. En este caso, el método
     * debe retornar un String.
     * com.app.springboot_aop.services.GreetingService: Especifica la clase completa
     * (con su paquete) que contiene los métodos.
     * *: Especifica cualquier método dentro de la clase GreetingService (o dentro
     * del paquete services).
     * (..): Indica que el método puede tener cualquier número y tipo de argumentos.
     * 
     * Ejecución
     * Cuando cualquier método de GreetingService que retorna un String es llamado
     * (por ejemplo, sayHello o sayGoodbye), el advice en LoggingAspect se ejecuta
     * después de que el método haya sido completado, imprimiendo el nombre del
     * método y sus argumentos después de su ejecución.
     * 
     * Conclusión
     * La anotación @After en Spring AOP se utiliza para definir un advice que se
     * ejecuta después de la ejecución de un método especificado por el pointcut. Es
     * útil para realizar tareas que deben ocurrir después de que el método ha sido
     * ejecutado, como el registro (logging), la limpieza de recursos o la
     * auditoría, asegurando que estas tareas se realicen sin importar el resultado
     * del método.
     */
    @After("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues: " + method + " con los argumentos " + args);
    }

    /*
     * Ejecución
     * 
     * @AfterReturning: Cuando un método de GreetingService que retorna un String se
     * ejecuta con éxito, el advice definido por @AfterReturning se ejecutará,
     * imprimiendo el valor retornado.
     * 
     * @AfterThrowing: Cuando un método de GreetingService lanza una excepción, el
     * advice definido por @AfterThrowing se ejecutará, imprimiendo la excepción
     * lanzada.
     * Conclusión
     * Las anotaciones @AfterReturning y @AfterThrowing en Spring AOP proporcionan
     * mecanismos específicos para ejecutar lógica adicional después de la ejecución
     * de métodos coincidentes, dependiendo de si el método retorna con éxito o
     * lanza una excepción. Estas capacidades permiten un manejo detallado y
     * específico de las ejecuciones de métodos, mejorando la capacidad de gestionar
     * y registrar el comportamiento de las aplicaciones.
     */

    /*
     * @AfterReturning
     * La anotación @AfterReturning se utiliza para definir un advice que se ejecuta
     * después de que un método coincidente retorna con éxito, es decir, sin lanzar
     * una excepción.
     * 
     * Propósito de @AfterReturning
     * Ejecutar código después de una ejecución exitosa: Permite ejecutar lógica
     * adicional después de que el método ha completado con éxito.
     * Acceso al valor retornado: Puede capturar y trabajar con el valor retornado
     * por el método.
     */
    @AfterReturning("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de retornar: " + method + " con los argumentos " + args);
    }

    /*
     * @AfterThrowing
     * La anotación @AfterThrowing se utiliza para definir un advice que se ejecuta
     * después de que un método coincidente lanza una excepción.
     * 
     * Propósito de @AfterThrowing
     * Ejecutar código después de una excepción: Permite ejecutar lógica adicional
     * después de que el método ha lanzado una excepción.
     * Acceso a la excepción lanzada: Puede capturar y trabajar con la excepción
     * lanzada por el método.
     */
    @AfterThrowing("GreetingServicePointcuts.greetingLoggerPointCut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de lanzar la excepcion: " + method + " con los argumentos " + args);
    }

    /*
     * La anotación @Around en Spring AOP se utiliza para definir un advice que
     * envuelve la ejecución de un método coincidente. Este tipo de advice permite
     * ejecutar lógica antes y después del método, así como controlar su ejecución,
     * modificar el valor de retorno o manejar excepciones de una manera
     * centralizada.
     * 
     * Propósito de @Around
     * Ejecutar lógica antes y después del método: Permite insertar lógica adicional
     * antes y después de la ejecución del método objetivo.
     * Control total sobre la ejecución del método: Permite decidir si el método
     * objetivo se ejecuta y cómo se maneja su valor de retorno o cualquier
     * excepción que se lance.
     * Flexibilidad en el manejo de excepciones: Permite capturar y manejar
     * excepciones lanzadas por el método objetivo.
     * ProceedingJoinPoint
     * Provee el control sobre la ejecución del método objetivo: ProceedingJoinPoint
     * es una subclase de JoinPoint que permite controlar si el método objetivo se
     * debe ejecutar y cuándo.
     * Método proceed(): Se utiliza para ejecutar el método objetivo. Puede ser
     * llamado sin argumentos o con una lista modificada de argumentos.
     * Obtener información sobre el método: Proporciona detalles como el nombre del
     * método, los argumentos, etc.
     * Uso de try-catch y Throwable
     * Captura de excepciones: El bloque try-catch se utiliza para capturar
     * cualquier excepción lanzada durante la ejecución del método objetivo.
     * Re-lanzamiento de excepciones: Al capturar Throwable, se asegura que todas
     * las excepciones, incluidas Exception y Error, sean manejadas. El advice puede
     * registrar la excepción y luego re-lanzarla para permitir su manejo aguas
     * arriba.
     * 
     * Explicación Resumida del Código
     * Definición del Aspecto (@Aspect y @Component): LoggingAspect se define como
     * un aspecto y un componente Spring.
     * Método loggerAround:
     * Pointcut: @Around("execution(String com.app.springboot_aop.services.GreetingService.*(..))"
     * ) especifica que este advice se aplica a cualquier método en GreetingService
     * que retorna un String.
     * Obtención de detalles del método: Se obtienen el nombre del método y los
     * argumentos.
     * Ejecución del método objetivo:
     * Antes de la ejecución: Se registra un mensaje con el nombre del método y los
     * argumentos.
     * Llamada a proceed(): Ejecuta el método objetivo.
     * Después de la ejecución: Se registra el resultado retornado por el método.
     * Manejo de excepciones:
     * Captura de Throwable: Se captura cualquier excepción lanzada.
     * Registro del error: Se registra un mensaje de error.
     * Re-lanzamiento de la excepción: La excepción se re-lanza para ser manejada
     * aguas arriba.
     * Conclusión
     * La anotación @Around proporciona una forma poderosa de controlar la ejecución
     * de métodos en Spring AOP, permitiendo ejecutar lógica antes y después del
     * método objetivo, modificar el valor de retorno, y manejar excepciones de
     * manera centralizada. ProceedingJoinPoint es clave para este control,
     * permitiendo decidir si y cuándo se ejecuta el método objetivo.
     */
    /*
     * Es de tipo Object porque devuelve el objeto de la ejecución del método, se
     * pasa como argumento ... porque es el que se está ejecutando, este aspecto
     * envuelve la ejecución de todos los demás Aspect
     */
    @Around("GreetingServicePointcuts.greetingLoggerPointCut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;
        try {
            logger.info("El metodo: " + method + "() con los argumentos " + args);
            result = joinPoint.proceed();
            logger.info("El metodo: " + method + "() retorna el resultado: " + result);
            return result;
        } catch (Throwable e) {
            logger.error("Error en la llamada del metodo " + method + "()");
            /* Se relanza la excepción para manejarla después, se agrega throws Throwable */
            throw e;
        }
    }
}
