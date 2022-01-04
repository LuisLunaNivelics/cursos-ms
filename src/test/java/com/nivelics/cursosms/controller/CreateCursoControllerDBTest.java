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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CreateCursoControllerDBTest {

    @Autowired
    private MockMvc mockMvc;

    InitCurso initCurso = new InitCurso();

    @Test
    void createConDB() throws Exception {
        Gson gson = new Gson();
        var cursoDto = initCurso.inicializarCursoSinId();
        var cursoJson = gson.toJson(cursoDto);
        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/cursos/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(cursoJson)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }
}