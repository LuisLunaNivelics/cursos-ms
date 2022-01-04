package com.nivelics.cursosms.controller;

import com.nivelics.cursosms.builder.InitCurso;
import com.nivelics.cursosms.entity.Curso;
import com.nivelics.cursosms.service.impl.CreateCursoServiceImpl;
import com.nivelics.cursosms.service.impl.FindAllCursoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@AutoConfigureMockMvc
class FIndAllCursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    FIndAllCursoController fIndAllCursoController;

    @Mock
    FindAllCursoServiceImpl findAllCursoService;

    @Mock
    InitCurso initCurso;

    @Test
    void findAll() {
        var cursoDto = initCurso.inicializarCurso();
        when(findAllCursoService.findAll()).thenReturn(Arrays.asList(Curso.builder().build()));
        var response = fIndAllCursoController.findAll();
        assertEquals(cursoDto, response);
    }
}