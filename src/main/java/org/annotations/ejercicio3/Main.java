package org.annotations.ejercicio3;

import org.annotations.ejercicio3.models.AgendaSemana;

public class Main {
    public static void main(String[] args) {
        AgendaSemana agendaSemana = AgendaSemana.cargadorDeContexto();
        System.out.println(agendaSemana);
    }
}
