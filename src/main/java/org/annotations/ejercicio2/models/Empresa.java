package org.annotations.ejercicio2.models;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Array;

@org.annotations.ejercicio2.annotations.Directivo(
    empleado = @org.annotations.ejercicio2.annotations.Empleado(
        nombre = "Amancio",
        apellidos = "Ortega",
        dni = "66554433F",
        direccion = "AV.DIPUTACION S/N, P.I. SABON 15142, ARTEIXO, LA CORUÑA",
        telefono = 981185596
    ),
    codigoDespacho = 1
)
@org.annotations.ejercicio2.annotations.Tecnico(
    operario = @org.annotations.ejercicio2.annotations.Operario(
        empleado = @org.annotations.ejercicio2.annotations.Empleado(
            nombre = "Lucas",
            apellidos = "Martinez",
            dni = "44214698C",
            direccion = "C. Porintia 18, Valencia",
            telefono = 678423987
        ),
        codigoTaller = 1
    ),
    perfil = "Derecho"
)
@org.annotations.ejercicio2.annotations.Oficial(
    operario = @org.annotations.ejercicio2.annotations.Operario(
        empleado = @org.annotations.ejercicio2.annotations.Empleado(
            nombre = "Marta",
            apellidos = "Gutierrez",
            dni = "31256892L",
            direccion = "A. Del Valles 16, Barcelona",
            telefono = 876498721
        ),
        codigoTaller = 2
    ),
    categoria = "Profesional"
)
public class Empresa {
    private List<Empleado> empleados = new ArrayList<>();

    public static Empresa cargadorDeContexto() {
        Empresa empresa = new Empresa();

        org.annotations.ejercicio2.annotations.Directivo[] directivos = Empresa.class.getAnnotationsByType(org.annotations.ejercicio2.annotations.Directivo.class);
        org.annotations.ejercicio2.annotations.Tecnico[] tecnicos = Empresa.class.getAnnotationsByType(org.annotations.ejercicio2.annotations.Tecnico.class);
        org.annotations.ejercicio2.annotations.Oficial[] oficiales = Empresa.class.getAnnotationsByType(org.annotations.ejercicio2.annotations.Oficial.class);

        List<Empleado> localEmpleados = new ArrayList<>();

        for (org.annotations.ejercicio2.annotations.Directivo directivo : directivos) {
            Directivo localDirectivo = new Directivo();

            iniciarEmpleado(localDirectivo, directivo.empleado());
            localDirectivo.setCodigoDespacho(directivo.codigoDespacho());

            localEmpleados.add(localDirectivo);
        }

        for (org.annotations.ejercicio2.annotations.Tecnico tecnico : tecnicos) {
            Tecnico localTecnico = new Tecnico();

            iniciarEmpleado(localTecnico, tecnico.operario().empleado());
            localTecnico.setCodigoTaller(tecnico.operario().codigoTaller());
            localTecnico.setPerfil(tecnico.perfil());

            localEmpleados.add(localTecnico);
        }

        for (org.annotations.ejercicio2.annotations.Oficial oficial : oficiales) {
            Oficial localOficial = new Oficial();

            iniciarEmpleado(localOficial, oficial.operario().empleado());
            localOficial.setCodigoTaller(oficial.operario().codigoTaller());
            localOficial.setCategoria(oficial.categoria());

            localEmpleados.add(localOficial);
        }

        empresa.setEmpleados(localEmpleados);
        return empresa;
    }

    private static void iniciarEmpleado(Empleado empleado, org.annotations.ejercicio2.annotations.Empleado anotacion) {
        empleado.setNombre(anotacion.nombre());
        empleado.setApellidos(anotacion.apellidos());
        empleado.setDireccion(anotacion.direccion());
        empleado.setDni(anotacion.dni());
        empleado.setTelefono(anotacion.telefono());
        empleado.setTelefono(anotacion.telefono());
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return empleados.toString();
    }
}
