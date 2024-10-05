package org.annotations.ejercicio3.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Tareas {
    Tarea[] value();
}
