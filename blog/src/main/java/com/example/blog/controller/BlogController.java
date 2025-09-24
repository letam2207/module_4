package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.exception.BlogNotFoundException;
import com.example.blog.service.CategoryService;
import com.example.blog.service.IBlogService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")

public class BlogController {

    private final IBlogService blogService;
    private final CategoryService categoryService;

    public BlogController(IBlogService blogService, CategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }


    @GetMapping
    public String getAllBlog(Model model , @RequestParam(name = "page", defaultValue = "0")int page) {
        Page<Blog> blogs = blogService.findAllPageable(page);
        model.addAttribute("blogs", blogs);
        return "blog/list";
    }

//    @GetMapping
//    public String getAllStudents(Model model) {
//        List<Blog> blogs = blogService.findAll();
//        model.addAttribute("blogs", blogs);
//        return "blog/list";
//    }

    @GetMapping("/create")
    public String createBlog(ModelMap model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categorys", categoryService.findAll());
        return "blog/create";
    }


    @PostMapping("/create")
    public String createBlog(@ModelAttribute("blog") Blog blog,
                             BindingResult bindingResult,
                             RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "blog/create";
        }
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/blog";
    }


    @GetMapping("/{id}")
    public String getBlogById(@PathVariable Integer id, ModelMap model) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return "redirect:/error";
        }
        model.addAttribute("blog", blog);
        return "blog/detail";
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Integer id, ModelMap model) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            throw new BlogNotFoundException("Không tìm thấy sản phẩm" + id);
        }
        model.addAttribute("blog", blog);
        return "blog/update";
    }


    @PostMapping("/update")
    public String updateBlog(@ModelAttribute("blog") Blog blog,
                             BindingResult bindingResult,
                             RedirectAttributes redirect,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "blog/update";
        }
        Blog existingBlog = blogService.findById(blog.getId_blog());
        if (existingBlog == null) {
            model.addAttribute("message", "Không tìm thấy sản phẩm với ID: " + blog.getId_blog());
            return "blog/error";
        }

        blogService.update(blog);
        redirect.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/blog";
    }



    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Integer id, RedirectAttributes redirect) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            throw new BlogNotFoundException("Không tìm thấy sản phẩm có ID: " + id);
        }
        blogService.delete(id);
        redirect.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/blog";
    }
}
