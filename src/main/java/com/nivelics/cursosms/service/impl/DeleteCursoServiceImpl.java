package com.nivelics.cursosms.service.impl;

import com.nivelics.cursosms.repository.CursoRepository;
import com.nivelics.cursosms.service.DeleteCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCursoServiceImpl implements DeleteCursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void delete(int id) {
        cursoRepository.deleteById(id);
    }
}
