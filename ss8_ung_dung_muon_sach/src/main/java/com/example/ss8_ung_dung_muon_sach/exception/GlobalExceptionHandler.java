package com.example.ss8_ung_dung_muon_sach.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleMismatch(MethodArgumentTypeMismatchException ex, Model model) {
        model.addAttribute("message", "Vui lòng nhập đúng định dạng số.");
        return "book/error";
    }


    @ExceptionHandler(BookNotFoundException.class)
    public String handleNotFound(BookNotFoundException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "book/error";
    }


    @ExceptionHandler(OutOfStockException.class)
    public String handleOutOfStock(OutOfStockException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "book/error";
    }


    @ExceptionHandler(Exception.class)
    public String handleGeneral(Exception ex, Model model) {
        model.addAttribute("message", "Có lỗi xảy ra: " + ex.getMessage());
        return "book/error";
    }
}
