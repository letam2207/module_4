package com.example.ss2_bai_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SandwichController {

    @GetMapping("/sandwich")
    public String index(Model model) {

        if (!model.containsAttribute("condiments")) {
            model.addAttribute("condiments", new String[]{});
        }
        return "condiment";
    }

    @PostMapping("/add")
    public String add(@RequestParam(value = "condiments", required = false) String[] condiments,
                      RedirectAttributes redirectAttributes) {
        if (condiments != null && condiments.length > 0) {
            redirectAttributes.addFlashAttribute("condiments", condiments);
        } else {
            redirectAttributes.addFlashAttribute("condiments", new String[]{});
        }
        return "redirect:/sandwich";
    }
}
