package com.example.teachersspring.controller;

import com.example.teachersspring.dto.TeacherDTO;
import com.example.teachersspring.repository.TeacherRepository;
import com.example.teachersspring.service.ITeacherService;

import com.example.teachersspring.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdateTeacherController {

    @Autowired
    ITeacherService teacherService;

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/teacherupdate")
    public String teacherUpdate() {
        return "teacherupdate";
    }
    @GetMapping("/update")
    public String update(@RequestParam("id") Long id,
                         @RequestParam("firstname") String firstname,
                         @RequestParam("lastname") String lastname, Model model) {
        TeacherDTO teacherDTO = new TeacherDTO(id, firstname, lastname);

        try {
            teacherService.updateTeacher(teacherDTO);
            model.addAttribute("teacher", teacherDTO);
            return "teacherupdated";
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            model.addAttribute("fail", true);
            return "teacherupdate";
        }
    }
}
