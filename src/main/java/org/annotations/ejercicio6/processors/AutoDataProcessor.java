package org.annotations.ejercicio6.processors;

import org.annotations.ejercicio6.annotations.AutoData;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Set;

@SupportedAnnotationTypes("org.annotations.ejercicio6.annotations.AutoData")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class AutoDataProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element elemento : roundEnv.getElementsAnnotatedWith(AutoData.class)) {
            if (elemento.getKind() != ElementKind.CLASS) return true;

            TypeElement tipoElemento = (TypeElement) elemento;
            PackageElement paqueteElemento = (PackageElement) tipoElemento.getEnclosingElement();

            String className = tipoElemento.getSimpleName().toString();
            String finalClassName = className + "AutoData";

            try {
                JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(finalClassName);

                try (BufferedWriter out = new BufferedWriter(builderFile.openWriter())) {
                    crearPaquete(out, paqueteElemento);
                    crearClase(out, finalClassName);
                    crearCampos(out, tipoElemento);
                    crearConstructor(out, finalClassName);
                    crearGettersYSetters(out, tipoElemento);
                    crearToString(out, finalClassName, tipoElemento);
                    out.append("}");
                }
            } catch (IOException e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, e.getMessage());
            }
        }

        return true;
    }

    private void crearPaquete(BufferedWriter out, PackageElement paqueteElemento) throws IOException {
        out.append("package ").append(paqueteElemento.getQualifiedName()).append(";");
        out.newLine();
        out.newLine();
    }

    private void crearClase(BufferedWriter out, String className) throws IOException {
        out.append("public class ").append(className).append(" {");
        out.newLine();
    }

    private void crearCampos(BufferedWriter out, TypeElement tipoElemento) throws IOException {
        for (Element elemento : tipoElemento.getEnclosedElements()) {
            if (elemento.getKind() == ElementKind.FIELD) {
                VariableElement campo = (VariableElement) elemento;
                out.append("    private ").append(campo.asType().toString()).append(" ").append(campo.getSimpleName()).append(";");
                out.newLine();
            }
        }
        out.newLine();
    }

    private void crearConstructor(BufferedWriter out, String className) throws IOException {
        out.append("    public ").append(className).append("() {}");
        out.newLine();
        out.newLine();
    }

    private void crearGettersYSetters(BufferedWriter out, TypeElement tipoElemento) throws IOException {
        for (Element elemento : tipoElemento.getEnclosedElements()) {
            if (elemento.getKind() == ElementKind.FIELD) {
                VariableElement campo = (VariableElement) elemento;
                String nombreCampo = campo.getSimpleName().toString();
                String tipoCampo = campo.asType().toString();
                String nombreCampoCap = nombreCampo.substring(0, 1).toUpperCase() + nombreCampo.substring(1);

                out.append("    public ").append(tipoCampo).append(" get").append(nombreCampoCap).append("() {");
                out.newLine();
                out.append("        return this.").append(nombreCampo).append(";");
                out.newLine();
                out.append("    }");
                out.newLine();
                out.newLine();

                out.append("    public void set").append(nombreCampoCap).append("(").append(tipoCampo).append(" ").append(tipoCampo).append(") {");
                out.newLine();
                out.append("        this.").append(nombreCampo).append(" = ").append(nombreCampo).append(";");
                out.newLine();
                out.append("    }");
                out.newLine();
                out.newLine();
            }
        }
    }

    private void crearToString(BufferedWriter out, String className, TypeElement tipoElemento) throws IOException {
        out.append("    @Override");
        out.newLine();
        out.append("    public String toString() {");
        out.newLine();
        out.append("        return \"").append(className).append("(\" +");
        out.newLine();

        for (int i = 0; i < tipoElemento.getEnclosedElements().size(); i++) {
            Element elemento = tipoElemento.getEnclosedElements().get(i);
            if (elemento.getKind() == ElementKind.FIELD) {
                String nombreCampo = elemento.getSimpleName().toString();
                out.append("                \"").append(nombreCampo).append("=\" + ").append(nombreCampo).append(" + ");
                if (i < tipoElemento.getEnclosedElements().size() - 1) {
                    out.append("\", \" +");
                }
            }
        }
        out.append("                \")\";");
        out.newLine();
        out.append("    }");
        out.newLine();
        out.newLine();
    }
}
