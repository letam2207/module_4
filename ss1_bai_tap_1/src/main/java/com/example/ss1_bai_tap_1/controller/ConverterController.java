package com.example.ss1_bai_tap_1.controller;

import com.example.ss1_bai_tap_1.service.IConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {

    @Autowired
    private IConverterService converterService;

    @GetMapping("/converter")
    private String home() {
        return "home";
    }

    @PostMapping("/converter")
    private String convert(Model model, @RequestParam("usd") Integer usd) {
        Integer vnd = converterService.convertUsdToVnd(usd);
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", usd);
        return "home";
    }
}
