package com.nivelics.cursosms.controller;

import com.nivelics.cursosms.entity.Curso;
import com.nivelics.cursosms.service.FindAllCursosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos/listar")
public class FIndAllCursoController {

    @Autowired
    private FindAllCursosService findAllCursosService;

    @GetMapping
    public List<Curso> findAll(){
        return findAllCursosService.findAll();
    }
}
