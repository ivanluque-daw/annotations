package org.annotations.ejercicio2.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Repeatable(Tecnicos.class)
public @interface Tecnico {
    Operario operario();
    String perfil();
}
