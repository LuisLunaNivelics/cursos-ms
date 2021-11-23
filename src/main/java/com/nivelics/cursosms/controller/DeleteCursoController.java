package com.nivelics.cursosms.controller;

import com.nivelics.cursosms.service.DeleteCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cursos/delete")
public class DeleteCursoController {

    @Autowired
    private DeleteCursoService deleteCursoService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        deleteCursoService.delete(id);
    }
}
