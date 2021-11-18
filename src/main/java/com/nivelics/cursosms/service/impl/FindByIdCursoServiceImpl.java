package com.nivelics.cursosms.service.impl;

import com.nivelics.cursosms.dto.CursoDto;
import com.nivelics.cursosms.entity.Curso;
import com.nivelics.cursosms.repository.CursoRepository;
import com.nivelics.cursosms.service.FindByIdCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindByIdCursoServiceImpl implements FindByIdCursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Curso findById(int id) {
        Optional<Curso> optCurso = cursoRepository.findById(id);
        if(optCurso.isEmpty()) return null;
        return  optCurso.get();
    }
}
