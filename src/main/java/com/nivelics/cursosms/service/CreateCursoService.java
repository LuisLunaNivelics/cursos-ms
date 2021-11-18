package com.nivelics.cursosms.service;

import com.nivelics.cursosms.dto.CursoDto;
import com.nivelics.cursosms.entity.Curso;

public interface CreateCursoService {

    CursoDto create(CursoDto cursoDto);
}
