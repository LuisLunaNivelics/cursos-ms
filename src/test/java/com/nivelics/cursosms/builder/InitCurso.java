package com.nivelics.cursosms.builder;

import com.nivelics.cursosms.dto.CursoDto;

public class InitCurso {
    public CursoDto inicializarCurso(){
        return CursoDto
                .builder()
                .id(4)
                .codigo("1234")
                .nombre("tercero A")
                .build();
    }
    public CursoDto inicializarCursoSinId(){
        return CursoDto
                .builder()
                .codigo("1234")
                .nombre("tercero A")
                .build();
    }
}
