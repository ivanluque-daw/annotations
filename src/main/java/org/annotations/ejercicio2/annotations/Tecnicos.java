package org.annotations.ejercicio2.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Tecnicos {
    Tecnico[] value();
}
