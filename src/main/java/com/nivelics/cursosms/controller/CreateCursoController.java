package com.nivelics.cursosms.controller;

import com.nivelics.cursosms.dto.CursoDto;
import com.nivelics.cursosms.service.CreateCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cursos/crear")
public class CreateCursoController {

    @Autowired
    private CreateCursoService createCursoService;

    @PostMapping
    public CursoDto create(@RequestBody CursoDto cursoDto){
      return createCursoService.create(cursoDto);
    }
}
