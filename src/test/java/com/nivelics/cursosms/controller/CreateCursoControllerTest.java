package com.nivelics.cursosms.controller;

import com.google.gson.Gson;
import com.nivelics.cursosms.builder.InitCurso;
import com.nivelics.cursosms.service.impl.CreateCursoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@AutoConfigureMockMvc
class CreateCursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    CreateCursoController cursoController;

    @Mock
    CreateCursoServiceImpl createCursoService;

    @Mock
    InitCurso initCurso;

    @Test
    void createMock() {
        var cursoDto = initCurso.inicializarCurso();
        when(createCursoService.create(cursoDto)).thenReturn(cursoDto);
        var response = cursoController.create(cursoDto);
        assertEquals(cursoDto, response);
    }
//https://www.udemy.com/cart/checkout/express/course/3934340/?discountCode=CYBER21
    @Test
    void createConDB() throws Exception {
        Gson gson = new Gson();
        var cursoDto = initCurso.inicializarCursoSinId();
        var cursoJson = gson.toJson(cursoDto);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/cursos/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(cursoJson)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }
}