package org.annotations.ejercicio4;

import org.annotations.ejercicio4.models.Empleado;
import org.annotations.ejercicio4.models.Persona;

public class Main {
    public static void main(String[] args){
        Empleado empleado = new Empleado();
        empleado.setNombre("Ivan");
        empleado.setCategoriaProfesional("Oficiales administrativos");
        empleado.setSalario(1260.50);

        System.out.println(empleado);

        Persona persona = Persona.builder().nombre("Ivan").build();

        System.out.println(persona);
    }
}