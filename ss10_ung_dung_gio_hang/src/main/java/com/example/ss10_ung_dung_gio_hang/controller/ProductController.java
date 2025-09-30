package com.example.ss10_ung_dung_gio_hang.controller;

import com.example.ss10_ung_dung_gio_hang.entity.Product;
import com.example.ss10_ung_dung_gio_hang.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/list";
    }


    @GetMapping("/{id}")
    public String viewProduct(@PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "product/detail";
    }
}
