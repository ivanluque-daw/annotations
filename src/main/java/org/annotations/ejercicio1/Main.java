package org.annotations.ejercicio1;

import org.annotations.ejercicio1.models.Empresa;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = Empresa.cargadorDeContexto();
        System.out.println(empresa);
    }
}