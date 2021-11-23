package com.nivelics.cursosms.controller;

import com.nivelics.cursosms.dto.CursoDto;
import com.nivelics.cursosms.service.UpdateCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/cursos/update")
public class UpdateCursoController {

    @Autowired
    private UpdateCursoService updateCursoService;

    @PutMapping("/{id}")
    public CursoDto update(@Valid @PathVariable int id, @RequestBody CursoDto cursoDto){
        return updateCursoService.update(id, cursoDto);
    }
}
