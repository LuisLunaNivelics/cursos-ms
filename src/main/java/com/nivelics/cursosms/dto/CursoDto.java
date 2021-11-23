package com.nivelics.cursosms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CursoDto {

    public int id;

    @NotBlank(message = "El código no debe estar vacío")
    @Size(max = 10)
    public String codigo;

    @NotBlank(message = "El nombre del curso no debe estar vacío")
    @Size(max = 20)
    public String nombre;
}
