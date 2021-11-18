package com.nivelics.cursosms.controller;

import com.nivelics.cursosms.entity.Curso;
import com.nivelics.cursosms.service.FindByIdCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cursos/listar")
public class FindByIdCursoController {

    @Autowired
    private FindByIdCursoService findByIdCursoService;

    @GetMapping("/{id}")
    public Curso findBiId(int id){
        return findByIdCursoService.findById(id);
    }
}
