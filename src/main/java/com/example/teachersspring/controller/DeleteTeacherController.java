package com.example.teachersspring.controller;

import com.example.teachersspring.dto.TeacherDTO;


import com.example.teachersspring.service.TeacherServiceImpl;
import com.example.teachersspring.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteTeacherController {

   

    @Autowired
    private TeacherServiceImpl teacherService;

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id,
                         @RequestParam("firstname") String firstname,
                         @RequestParam("lastname") String lastname, Model model) {
        TeacherDTO teacherDTO = new TeacherDTO(id, firstname, lastname);
        try {
            teacherService.deleteTeacher(teacherDTO);
            model.addAttribute("teacher", teacherDTO);
            return "teacherdeleted";
        } catch (EntityNotFoundException e) {
            model.addAttribute("deleteAPIError", true);
            return "teachers";
        }
    }

}
