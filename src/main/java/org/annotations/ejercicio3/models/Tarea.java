package org.annotations.ejercicio3.models;

import org.annotations.ejercicio3.enums.DiaSemana;

public class Tarea {
    private String titulo;
    private String descripcion;
    private DiaSemana dia;
    private String hora;

    public Tarea() {}

    public Tarea(String titulo, String descripcion, DiaSemana dia, String hora) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.dia = dia;
        this.hora = hora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\n" + "Descripción: " + descripcion + "\n" +  "Día: " + dia + "\n" + "Hora: " + hora;
    }
}
