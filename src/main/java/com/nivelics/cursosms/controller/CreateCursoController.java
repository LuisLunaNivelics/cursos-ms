package com.nivelics.cursosms.controller;

import com.nivelics.cursosms.dto.CursoDto;
import com.nivelics.cursosms.service.CreateCursoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/cursos/crear")
public class CreateCursoController {


    private final CreateCursoService createCursoService;

    public CreateCursoController(CreateCursoService createCursoService) {
        this.createCursoService = createCursoService;
    }

    @PostMapping
    public CursoDto create(@Valid @RequestBody CursoDto cursoDto){
      return createCursoService.create(cursoDto);
    }
}
