package org.annotations.ejercicio1.models;

import java.util.ArrayList;
import java.util.List;

@org.annotations.ejercicio1.annotations.Empleado(
    nombre = "Amancio",
    apellidos = "Ortega",
    dni = "66554433F",
    direccion = "AV.DIPUTACION S/N, P.I. SABON 15142, ARTEIXO, LA CORUÑA",
    telefono = 981185596,
    clase = "Directivo",
    codigoDespacho = 1
)
@org.annotations.ejercicio1.annotations.Empleado(
    nombre = "Lucas",
    apellidos = "Martinez",
    dni = "44214698C",
    direccion = "C. Porintia 18, Valencia",
    telefono = 678423987,
    clase = "Tecnico",
    codigoTaller = 1,
    perfil = "Derecho"
)
@org.annotations.ejercicio1.annotations.Empleado(
    nombre = "Marta",
    apellidos = "Gutierrez",
    dni = "31256892L",
    direccion = "A. Del Valles 16, Barcelona",
    telefono = 876498721,
    clase = "Oficial",
    codigoTaller = 2,
    categoria = "Profesional"
)
public class Empresa {
    private List<Empleado> empleados = new ArrayList<>();

    public static Empresa cargadorDeContexto() {
        Empresa empresa = new Empresa();
        org.annotations.ejercicio1.annotations.Empleado[] empleados = Empresa.class.getAnnotationsByType(org.annotations.ejercicio1.annotations.Empleado.class);
        List<Empleado> localEmpleados = new ArrayList<>();

        for (org.annotations.ejercicio1.annotations.Empleado empleado : empleados) {
            String clase = empleado.clase();

            if (clase.equals("Directivo")) {
                Directivo directivo = new Directivo();

                iniciarEmpleado(directivo, empleado);
                directivo.setCodigoDespacho(empleado.codigoDespacho());

                localEmpleados.add(directivo);
            } else if (clase.equals("Tecnico")) {
                Tecnico tecnico = new Tecnico();

                iniciarEmpleado(tecnico, empleado);
                tecnico.setCodigoTaller(empleado.codigoTaller());
                tecnico.setPerfil(empleado.perfil());

                localEmpleados.add(tecnico);
            } else if (clase.equals("Oficial")) {
                Oficial oficial = new Oficial();

                iniciarEmpleado(oficial, empleado);
                oficial.setCodigoTaller(empleado.codigoTaller());
                oficial.setCategoria(empleado.categoria());

                localEmpleados.add(oficial);
            }
        }

        empresa.setEmpleados(localEmpleados);
        return empresa;
    }

    private static void iniciarEmpleado(Empleado empleado, org.annotations.ejercicio1.annotations.Empleado anotacion) {
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
