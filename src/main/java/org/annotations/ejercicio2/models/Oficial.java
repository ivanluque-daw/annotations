package org.annotations.ejercicio2.models;

public class Oficial extends Operario {
    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Oficial=(nombre=" + this.getNombre() + ", dni=" + this.getDni() + ")";
    }
}
