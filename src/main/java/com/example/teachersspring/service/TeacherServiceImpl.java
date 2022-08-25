package com.example.teachersspring.service;

import com.example.teachersspring.dto.TeacherDTO;
import com.example.teachersspring.model.Teacher;
import com.example.teachersspring.repository.TeacherRepository;
import com.example.teachersspring.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService{


    @Autowired
    private TeacherRepository teacherRepository;



    @Override
    public void insertTeacher(TeacherDTO teacherDTO) {
        teacherRepository.save(convertToTeacher(teacherDTO));
    }

    @Override
    public void deleteTeacher(TeacherDTO teacherDTO) throws EntityNotFoundException {
        teacherRepository.delete(convertToTeacher(teacherDTO));
    }

    @Override
    public void updateTeacher(TeacherDTO teacherDTO) throws EntityNotFoundException {
        teacherRepository.save(convertToTeacher(teacherDTO));
    }

    @Override
    public List<Teacher> getTeachersByLastname(String lastname) throws EntityNotFoundException {
        List<Teacher> teachers = null;
        teachers = teacherRepository.getTeacherByLastname(lastname);
        if (teachers.isEmpty()) throw new  EntityNotFoundException(Teacher.class, 0L);
        return teachers;
    }

    private static Teacher convertToTeacher(TeacherDTO teacherDTO) {
        return new Teacher(teacherDTO.getId(), teacherDTO.getFirstname(), teacherDTO.getLastname());
    }
}
