package org.annotations.ejercicio3.annotations;

import org.annotations.ejercicio3.enums.DiaSemana;

import java.lang.annotation.*;

@Repeatable(Tareas.class)
public @interface Tarea {
    String titulo();
    String descripcion();
    DiaSemana dia();
    String hora();
}

