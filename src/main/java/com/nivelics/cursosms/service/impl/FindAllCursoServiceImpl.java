package com.nivelics.cursosms.service.impl;

import com.nivelics.cursosms.entity.Curso;
import com.nivelics.cursosms.repository.CursoRepository;
import com.nivelics.cursosms.service.FindAllCursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllCursoServiceImpl implements FindAllCursosService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }
}
