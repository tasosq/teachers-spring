package com.example.teachersspring.controller;

import com.example.teachersspring.dto.TeacherDTO;
import com.example.teachersspring.model.Teacher;
import com.example.teachersspring.repository.TeacherRepository;
import com.example.teachersspring.service.TeacherServiceImpl;
import com.example.teachersspring.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchTeacherController {

    @Autowired
    TeacherServiceImpl teacherService;

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/search")
    public String search(@RequestParam("lastname") String lastname, Model model) {
        List<Teacher> teachers = new ArrayList<>();
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setLastname(lastname);

        try {
            teachers = teacherService.getTeachersByLastname(lastname);
            model.addAttribute("teachers",teachers);
            return "teachers";
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            model.addAttribute("teachersNotFound", true);
            return "teachersmenu";
        }
    }
}
