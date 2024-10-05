package org.annotations.ejercicio1.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Empleados {
    Empleado[] value();
}
