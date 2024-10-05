package org.annotations.ejercicio2;

import org.annotations.ejercicio2.models.Empresa;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = Empresa.cargadorDeContexto();
        System.out.println(empresa);
    }
}