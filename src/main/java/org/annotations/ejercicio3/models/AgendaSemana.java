package org.annotations.ejercicio3.models;

import org.annotations.ejercicio1.models.Empleado;
import org.annotations.ejercicio3.models.Tarea;
import org.annotations.ejercicio3.enums.DiaSemana;

import java.util.ArrayList;
import java.util.List;

@org.annotations.ejercicio3.annotations.Tarea(
    titulo = "Comprar el pan",
    descripcion = "El de la tienda de la esquina",
    dia = DiaSemana.LUNES,
    hora = "13:30"
)
@org.annotations.ejercicio3.annotations.Tarea(
    titulo = "Pedir la cena",
    descripcion = "Pizza y un refresco nuevo",
    dia = DiaSemana.VIERNES,
    hora = "21:45"
)
public class AgendaSemana {
    private List<Tarea> tareas = new ArrayList<>();

    public static AgendaSemana cargadorDeContexto() {
        AgendaSemana agenda = new AgendaSemana();
        org.annotations.ejercicio3.annotations.Tarea[] tareas = AgendaSemana.class.getAnnotationsByType(org.annotations.ejercicio3.annotations.Tarea.class);
        List<Tarea> localTareas = new ArrayList<>();

        for (org.annotations.ejercicio3.annotations.Tarea tarea : tareas) {
            Tarea localTarea = new Tarea(tarea.titulo(), tarea.descripcion(), tarea.dia(), tarea.hora());
            localTareas.add(localTarea);
        }

        agenda.setTareas(localTareas);
        return agenda;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (int i = 0; i < tareas.size(); i++) {
            toReturn += tareas.get(i).toString();
            if (i < tareas.size() - 1) {
                toReturn += "\n--------------------\n";
            }
        }

        return toReturn;
    }
}
