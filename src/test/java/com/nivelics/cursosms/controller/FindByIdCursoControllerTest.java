package com.nivelics.cursosms.controller;

import com.nivelics.cursosms.entity.Curso;
import com.nivelics.cursosms.service.FindByIdCursoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FindByIdCursoController.class)
class FindByIdCursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindByIdCursoService findByIdCursoService;

    @Test
    void testFindBiId() throws Exception {
        when(findByIdCursoService.findById(1)).thenReturn(Curso.builder().build());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cursos/listar/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) ;
    }
}