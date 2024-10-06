package org.annotations.ejercicio4.models;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Persona {
    @NonNull
    String nombre;
    int edad;
}
