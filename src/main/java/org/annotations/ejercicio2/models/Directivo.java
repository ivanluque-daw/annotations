package org.annotations.ejercicio2.models;

public class Directivo extends Empleado {
    private int codigoDespacho;

    public int getCodigoDespacho() {
        return codigoDespacho;
    }

    public void setCodigoDespacho(int codigoDespacho) {
        this.codigoDespacho = codigoDespacho;
    }

    @Override
    public String toString() {
        return "Directivo=(nombre=" + this.getNombre() + ", dni=" + this.getDni() + ")";
    }
}
