package com.example.blog.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleMismatch(MethodArgumentTypeMismatchException ex, Model model) {
        model.addAttribute("message", " Vui lòng nhập số.");
        return "blog/error";
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public String handleNotFound(BlogNotFoundException ex, Model model) {
        model.addAttribute("message", " " + ex.getMessage());
        return "blog/error";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneral(Exception ex, Model model) {
        model.addAttribute("message", " Có lỗi xảy ra: " + ex.getMessage());
        return "blog/error";
    }
}
