package com.nivelics.cursosms.converter;

import com.nivelics.cursosms.dto.CursoDto;
import com.nivelics.cursosms.entity.Curso;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CursoConverter {

    public Curso dtoToEntity(CursoDto cursoDto){
        var curso = new Curso();
        BeanUtils.copyProperties(cursoDto, curso);
        return curso;
    }

    public CursoDto entityToDto(Curso curso){
        var cursoDto = new CursoDto();
        BeanUtils.copyProperties(curso, cursoDto);
        return cursoDto;
    }
}
