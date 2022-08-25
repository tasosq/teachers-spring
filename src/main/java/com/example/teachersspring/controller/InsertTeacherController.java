package com.example.teachersspring.controller;

import com.example.teachersspring.dto.TeacherDTO;
import com.example.teachersspring.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InsertTeacherController {

  
    @Autowired
    private TeacherServiceImpl teacherService;



    @GetMapping("/insert")
    public String insert(@RequestParam("lastname") String lastname, @RequestParam("firstname") String firstname) {
        String lastnameDTO = lastname.trim();
        String firstnameDTO = firstname.trim();

        //Construct DTO
        TeacherDTO teacherDTO = new TeacherDTO(firstnameDTO,lastnameDTO);
        teacherService.insertTeacher(teacherDTO);

        //Return teacherinserted.html
        return "teacherinserted";
    }

    // Going back to teachers menu
    @GetMapping("/teachersmenu")
    public String backToMenu() {
        return "teachersmenu";
    }


}
