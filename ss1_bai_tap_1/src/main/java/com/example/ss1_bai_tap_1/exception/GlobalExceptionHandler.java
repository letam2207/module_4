package com.example.ss1_bai_tap_1.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handlerMismatch(MethodArgumentTypeMismatchException ex , Model model){
        model.addAttribute("message","Vui lòng nhập số");
        return "error";
    }
}
