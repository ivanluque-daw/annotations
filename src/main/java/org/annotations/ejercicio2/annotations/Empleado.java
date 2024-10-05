package org.annotations.ejercicio2.annotations;

public @interface Empleado {
    String nombre();
    String apellidos();
    String dni();
    String direccion();
    int telefono();
    int codigoDespacho() default 0;
    int codigoTaller() default 0;
    String perfil() default "";
    String categoria() default "";
}

