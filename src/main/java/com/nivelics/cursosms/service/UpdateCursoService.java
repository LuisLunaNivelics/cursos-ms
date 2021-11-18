package com.nivelics.cursosms.service;

import com.nivelics.cursosms.dto.CursoDto;

public interface UpdateCursoService {

    CursoDto update(int id, CursoDto cursoDto);
}
