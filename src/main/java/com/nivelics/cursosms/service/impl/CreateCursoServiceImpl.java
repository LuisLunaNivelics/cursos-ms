package com.nivelics.cursosms.service.impl;

import com.nivelics.cursosms.converter.CursoConverter;
import com.nivelics.cursosms.dto.CursoDto;
import com.nivelics.cursosms.entity.Curso;
import com.nivelics.cursosms.repository.CursoRepository;
import com.nivelics.cursosms.service.CreateCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCursoServiceImpl implements CreateCursoService {

    @Autowired
    private CursoConverter cursoConverter;

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public CursoDto create(CursoDto cursoDto) {
        Curso curso = cursoConverter.dtoToEntity(cursoDto);
        curso = cursoRepository.save(curso);
        return cursoConverter.entityToDto(curso);
    }
}
