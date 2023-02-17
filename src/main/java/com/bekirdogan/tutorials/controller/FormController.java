package com.bekirdogan.tutorials.controller;

import com.bekirdogan.dto.TeacherDto;
import javax.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class FormController {

    // Form
    // @GetMapping
    // @PostMapping
    // @PutMapping
    // @DeleteMapping

    // Get Method
    // http://localhost:8080/form
    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("cv_teacher", new TeacherDto());
        return "form_post/formvalidation";
    }

    // Post Method
    // http://localhost:8080/form
    @PostMapping("/form")
    public String postForm(@Valid @ModelAttribute("cv_teacher") TeacherDto teacherDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            log.error("There are errors");
            System.out.println("There are errors");
            return "form_post/formvalidation";
        }
        log.info("Success !" + teacherDto);
        return "form_post/success";
    }
}
