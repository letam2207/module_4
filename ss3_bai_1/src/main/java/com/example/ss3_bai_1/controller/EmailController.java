package com.example.ss3_bai_1.controller;

import com.example.ss3_bai_1.entity.Email;
import com.example.ss3_bai_1.service.IEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/settings")
public class EmailController {

    private final IEmailService emailService;

    public EmailController(IEmailService emailService) {
        this.emailService = emailService;
    }


    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("settings", emailService.getSettings());
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5, 10, 15, 25, 50, 100});
        return "settings"; // settings.jsp
    }


    @PostMapping
    public String update(@ModelAttribute("settings") Email updated, Model model) {
        emailService.update(updated);


        model.addAttribute("settings", emailService.getSettings());
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5, 10, 15, 25, 50, 100});

        return "view";
    }
}
