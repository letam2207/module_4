package com.example.ss2_bai_2.controller;

import com.example.ss2_bai_2.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculator")
    public String home() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam(value = "num1", defaultValue = "0") float num1,
                            @RequestParam(value = "num2", defaultValue = "0") float num2,
                            @RequestParam("operator") String operator,
                            RedirectAttributes attributes) {
        String result = calculatorService.calculate(num1, num2, operator);

        attributes.addFlashAttribute("result", result);
        attributes.addFlashAttribute("num1", num1);
        attributes.addFlashAttribute("num2", num2);
        attributes.addFlashAttribute("operator", operator);

        return "redirect:/calculator";
    }
}
