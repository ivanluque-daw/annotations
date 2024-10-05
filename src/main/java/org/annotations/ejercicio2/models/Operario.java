package org.annotations.ejercicio2.models;

public abstract class Operario extends Empleado {
    private int codigoTaller;

    public int getCodigoTaller() {
        return codigoTaller;
    }

    public void setCodigoTaller(int codigoTaller) {
        this.codigoTaller = codigoTaller;
    }
}
