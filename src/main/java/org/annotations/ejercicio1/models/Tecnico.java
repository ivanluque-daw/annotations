package org.annotations.ejercicio1.models;

public class Tecnico extends Operario {
    private String perfil;

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Tecnico=(nombre=" + this.getNombre() + ", dni=" + this.getDni() + ")";
    }
}
