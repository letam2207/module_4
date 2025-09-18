package com.example.ss2_bai_2.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public String calculate(float num1, float num2, String operator) {
        switch (operator) {
            case "add":
                return String.valueOf(num1 + num2);
            case "sub":
                return String.valueOf(num1 - num2);
            case "mul":
                return String.valueOf(num1 * num2);
            case "div":
                if (num2 == 0) {
                    return "Can not divide by 0";
                }
                return String.valueOf(num1 / num2);
            default:
                return "Invalid operator";
        }
    }
}
