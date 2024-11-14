package com.practica.crud.Model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class Usuarios implements Serializable {
    private Long id;
    private String nombre;
    private String apellido;
    @NotNull(message = "La edad no puede ser nula")
    private Integer edad;
    private float nota;

}
