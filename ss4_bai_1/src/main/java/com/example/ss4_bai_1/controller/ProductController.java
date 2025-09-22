package com.example.ss4_bai_1.controller;

import com.example.ss4_bai_1.entity.Product;
import com.example.ss4_bai_1.exception.ProductNotFoundException;
import com.example.ss4_bai_1.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public String getAllProduct(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/list";
    }


    @GetMapping("/create")
    public String createProduct(ModelMap model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }


    @PostMapping("/create")
    public String createProduct(@ModelAttribute("product") Product product,
                                BindingResult bindingResult,
                                RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "product/create";
        }
        productService.add(product);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/product";
    }


    @GetMapping("/{id}")
    public String getProductById(@PathVariable Integer id, ModelMap model) {
        Product product = productService.searchById(id);
        if (product == null) {
            return "redirect:/error";
        }
        model.addAttribute("product", product);
        return "product/detail";
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, ModelMap model) {
        Product product = productService.searchById(id);
        if (product == null) {
            throw new ProductNotFoundException("Không tìm thấy sản phẩm" + id);
        }
        model.addAttribute("product", product);
        return "product/update";
    }


    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product,
                                BindingResult bindingResult,
                                RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "product/update";
        }
        productService.update(product);
        redirect.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/product";
    }


    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id, RedirectAttributes redirect) {
        productService.delete(id);
        redirect.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/product";
    }


    @GetMapping("/search")
    public String searchProduct(@RequestParam("name") String name, Model model) {
        List<Product> products = productService.searchByName(name);
        model.addAttribute("products", products);
        model.addAttribute("search", name);
        return "product/list";
    }

}
