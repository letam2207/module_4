package com.example.ss5_bai_1.controller;

import com.example.ss5_bai_1.dto.ProductDto;
import com.example.ss5_bai_1.entity.Product;
import com.example.ss5_bai_1.exception.ProductNotFoundException;
import com.example.ss5_bai_1.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    // ==================== HIỂN THỊ DANH SÁCH ====================
    @GetMapping
    public String getAllProduct(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/list";
    }

    // ==================== TẠO MỚI SẢN PHẨM ====================
    @GetMapping("/create")
    public String createProductForm(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "product/create";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("productDto") ProductDto productDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "product/create";
        }

        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.save(product);

        redirect.addFlashAttribute("message", " Thêm mới sản phẩm thành công!");
        return "redirect:/product";
    }

    // ==================== CHI TIẾT SẢN PHẨM ====================
    @GetMapping("/{id}")
    public String getProductById(@PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Không tìm thấy sản phẩm có ID: " + id);
        }
        model.addAttribute("product", product);
        return "product/detail";
    }

    // ==================== CẬP NHẬT SẢN PHẨM ====================
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Không tìm thấy sản phẩm có ID: " + id);
        }

        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);

        model.addAttribute("productDto", productDto);
        return "product/update";
    }

    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("productDto") ProductDto productDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirect,
                                Model model) {
        if (bindingResult.hasErrors()) {
            return "product/update";
        }

        Product existingProduct = productService.findById(productDto.getId());
        if (existingProduct == null) {
            model.addAttribute("message", "Không tìm thấy sản phẩm với ID: " + productDto.getId());
            return "product/error";
        }

        BeanUtils.copyProperties(productDto, existingProduct);
        productService.update(existingProduct);

        redirect.addFlashAttribute("message", "Cập nhật sản phẩm thành công!");
        return "redirect:/product";
    }

    // ==================== XÓA SẢN PHẨM ====================
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id, RedirectAttributes redirect) {
        Product product = productService.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Không tìm thấy sản phẩm có ID: " + id);
        }

        productService.delete(id);
        redirect.addFlashAttribute("message", " Xóa sản phẩm thành công!");
        return "redirect:/product";
    }

    // ==================== TÌM KIẾM SẢN PHẨM ====================
    @GetMapping("/search")
    public String searchProduct(@RequestParam("name") String name, Model model) {
        List<Product> products = productService.findByName(name);
        model.addAttribute("products", products);
        model.addAttribute("search", name);
        return "product/list";
    }
}
