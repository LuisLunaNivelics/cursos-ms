package com.nivelics.cursosms.service.impl;

import com.nivelics.cursosms.converter.CursoConverter;
import com.nivelics.cursosms.dto.CursoDto;
import com.nivelics.cursosms.entity.Curso;
import com.nivelics.cursosms.repository.CursoRepository;
import com.nivelics.cursosms.service.FindByIdCursoService;
import com.nivelics.cursosms.service.UpdateCursoService;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateCursoServiceImpl implements UpdateCursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private FindByIdCursoService findByIdCursoService;

    @Autowired
    private CursoConverter cursoConverter;

    @Override
    public CursoDto update(int id, CursoDto cursoDto) {
        Curso cursoOld = findByIdCursoService.findById(id);
        Curso curso = cursoConverter.dtoToEntity(cursoDto);
        cursoOld.setCodigo(curso.getCodigo());
        cursoOld.setNombre(curso.getNombre());
        curso = cursoRepository.save(cursoOld);
        return cursoConverter.entityToDto(curso);
    }
}
