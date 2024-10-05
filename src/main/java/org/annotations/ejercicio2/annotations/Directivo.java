package org.annotations.ejercicio2.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Repeatable(Directivos.class)
public @interface Directivo {
    Empleado empleado();
    int codigoDespacho();
}
